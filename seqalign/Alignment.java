package impl;
import java.io.*;
import impl.ScoreMatrix;


class MatchInfo {
  int rowPos;
  int columnPos;
  int maxPos;
  float maxScore;
  int outLen;
  public MatchInfo() {
    rowPos = columnPos = maxPos = 0;
    outLen = 0;
    maxScore = 0.0f;
  }
}

public class Alignment {
  char seq1[], seq2[];
  char outSeq1[], outSeq2[];
  char traceBackFlag[];
  float maxScore[], hGapScore[], vGapScore[];
  int outLen;
  MatchInfo matchInfo;
  ScoreMatrix scoreMatrix;
  int rowNum, columnNum;

  public static final char PATH_END = 0;

  public Alignment() {
    seq1 = seq2 = null;
    scoreMatrix = null;
    maxScore = hGapScore = vGapScore = null;
    traceBackFlag = null;
    rowNum = columnNum = 0;
    matchInfo = new MatchInfo();
    scoreMatrix = new ScoreMatrix();
    outLen = 0;
  }

  public void setSequences(char[] s1, char[] s2) {
    if (s1.length > s2.length) {
      seq1 = s1;
      seq2 = s2;
    }
    else {
      seq2 = s1;
      seq1 = s2;
    }

    scoreMatrix.encoding(seq1);
    scoreMatrix.encoding(seq2);

    rowNum = seq1.length + 1;
    columnNum = seq2.length + 1;

    int outMaxSize = seq1.length + seq2.length;
    outSeq1 = new char[outMaxSize];
    outSeq2 = new char[outMaxSize];
    int matrixSize = rowNum * columnNum;
    maxScore = new float[matrixSize];
    hGapScore = new float[matrixSize];
    vGapScore = new float[matrixSize];
    traceBackFlag = new char[matrixSize];

    int i;
    for (i = 0; i < rowNum; i++) {
      int pos = i * columnNum;
      traceBackFlag[pos] = PATH_END;
      maxScore[pos] = hGapScore[pos] = vGapScore[pos] = 0.0f;
    }

    for (i = 0; i < columnNum; i++) {
      traceBackFlag[i] = PATH_END;
      maxScore[i] = hGapScore[i] = vGapScore[i] = 0.0f;
    }
  }

  public void matchString(float openGapPenalty,
                          float extGapPenalty) {
    // rowNum >= columnNum;
    int i, j, pos;
    float maxDist, dist, nGapDist, hGapDist, vGapDist, extDist;
    for (i = 1; i < rowNum; i++) {
      for (j = 1; j < columnNum; j++) {
        pos = (i - 1) * columnNum + j - 1;
        maxDist = maxScore[pos];
        dist = (float)scoreMatrix.blosum62[seq1[i - 1]][seq2[j - 1]];
        nGapDist = maxDist + dist;

        pos++;
        extDist = hGapScore[pos] - extGapPenalty;
        hGapDist = maxScore[pos] - openGapPenalty;
        if (hGapDist <= extDist) {
          hGapDist = extDist;
          traceBackFlag[pos] += 4;
        }

        pos = pos + columnNum - 1;
        extDist = vGapScore[pos] - extGapPenalty;
        vGapDist = maxScore[pos] - openGapPenalty;
        if (vGapDist <= extDist) {
          vGapDist = extDist;
          traceBackFlag[pos] += 8;
        }

        nGapDist = (nGapDist > 0.0f) ? nGapDist : 0.0f;
        hGapDist = (hGapDist > 0.0f) ? hGapDist : 0.0f;
        vGapDist = (vGapDist > 0.0f) ? vGapDist : 0.0f;

        pos++;
        hGapScore[pos] = hGapDist;
        vGapScore[pos] = vGapDist;

        if (nGapDist >= hGapDist && nGapDist >= vGapDist) {
          maxDist = nGapDist;
          traceBackFlag[pos] = 2;
        }
        else if (hGapDist >= nGapDist && hGapDist >= vGapDist) {
          maxDist = hGapDist;
          traceBackFlag[pos] = 1;
        }
        else {
          maxDist = vGapDist;
          traceBackFlag[pos] = 3;
        }

        maxScore[pos] = maxDist;

        if (maxDist <= 0.0000001f) {
          traceBackFlag[pos] = PATH_END;
        }

        if (matchInfo.maxScore < maxDist) {
          matchInfo.rowPos = i;
          matchInfo.columnPos = j;
          matchInfo.maxPos = pos;
          matchInfo.maxScore = maxDist;
        }
      }
    }
  }

  public void printMaxMatchInfo() {
    System.out.format("\tnposi = %d\n", matchInfo.rowPos);
    System.out.format("\tnposj = %d\n", matchInfo.columnPos);
    System.out.format("\tnmaxPos = %d\n", matchInfo.maxPos);
    System.out.format("\tmaxCore = %.1f\n", matchInfo.maxScore);
  }

  public void traceBack() {
    int i, j, pos;
    int pathFlag;

    i = matchInfo.rowPos;
    j = matchInfo.columnPos;
    pos = matchInfo.maxPos;
    pathFlag = (int)traceBackFlag[pos] & 0x3;
    outLen = 0;
    while (Boolean.TRUE) {
      if (pathFlag == 3) {
        outSeq1[outLen] = 23;
        outSeq2[outLen] = seq2[j - 1];
        outLen++;
        j--;
      }
      else if (pathFlag == 1) {
        outSeq1[outLen] = seq1[i - 1];
        outSeq2[outLen] = 23;
        outLen++;
        i--;
      }
      else if (pathFlag == 2) {
        outSeq1[outLen] = seq1[i - 1];
        outSeq2[outLen] = seq2[j - 1];
        outLen++;
        i--;
        j--;
      }
      else {
        System.out.println("PathFlag = " + pathFlag);
        System.out.println("Path flag error!");
      }

      // only if it is not an extension gap, will the path
      // flag change.
      pos = i * columnNum + j;
      int extFlag = (int)traceBackFlag[pos] / 4;
      if (pathFlag == 3 && (extFlag == 2 || extFlag == 3)) {
        pathFlag = 3;
      }
      else if (pathFlag == 1 && (extFlag == 1 || extFlag == 3)) {
        pathFlag = 1;
      }
      else {
        pathFlag = (int)traceBackFlag[pos] & 0x3;
      }

      if (i == 0 || j == 0) {
        break;
      }

      if (pathFlag == PATH_END) {
        break;
      }
    }

    i--;
    j--;

    while (i >= 0) {
      outSeq1[outLen] = seq1[i];
      outSeq2[outLen] = 23;
      outLen++;
      i--;
    }

    while (j >= 0) {
      outSeq1[outLen] = 23;
      outSeq2[outLen] = seq2[j];
      outLen++;
      j--;
    }

    matchInfo.outLen = outLen;

    return;
  }

  public void printAlignment(int charsPerLine,
                             float openGapPenalty,
                             float extGapPenalty) {
    int i, j, pos;
    int startPos1, startPos2;
    int startMiss;
    char[] interStr;
    int interPos;
    int flag;

    interStr = new char[outLen];

    interPos = 0;
    flag = 0;
    startMiss = 0;
    startPos1 = startPos2 = 0;

    for (i = 0; i < outLen; i++) {
      if (flag == 0) {
        if (outSeq1[outLen - 1 - i] != outSeq2[outLen - 1 - i]) {
          if (outSeq1[outLen - 1 - i] != 23) {
            startPos1++;
          }

          if (outSeq2[outLen - 1 - i] != 23) {
            startPos2++;
          }

          startMiss++;
          continue;
        }
        else {
          flag = 1;
        }
      }

      if (outSeq1[outLen - 1 - i] == 23 || outSeq2[outLen - 1 - i] == 23) {
        interStr[interPos++] = ' ';
      }
      else if (outSeq1[outLen - 1 - i] != outSeq2[outLen - 1 - i]) {
        interStr[interPos++] = '.';
      }
      else {
        interStr[interPos++] = '|';
      }
    }

    System.out.println("Start posision: Sequence1: " + startPos1);
    System.out.println("                Sequence2: " + startPos2);

    int totalLines = (outLen - startMiss) / charsPerLine;
    for (i = 0; i < totalLines; i++) {
      for (j = 0; j < charsPerLine; j++) {
        pos = i * charsPerLine + startMiss + j;
        System.out.format("%c", scoreMatrix.amino_acids[outSeq1[outLen - 1 - pos]]);
      }
      System.out.println();
      for (j = 0; j < charsPerLine; j++) {
        pos = i * charsPerLine + j;
        System.out.format("%c", interStr[pos]);
      }
      System.out.println();
      for (j = 0; j < charsPerLine; j++) {
        pos = i * charsPerLine + startMiss + j;
        System.out.format("%c", scoreMatrix.amino_acids[outSeq2[outLen - 1 - pos]]);
      }
      System.out.println();
      System.out.println();
    }

    int nRemainingChars = outLen - startMiss - totalLines * charsPerLine;
    if (nRemainingChars > 0) {
      for (j = 0; j < nRemainingChars; j++) {
        System.out.format("%c", scoreMatrix.amino_acids[outSeq1[nRemainingChars - 1 - j]]);
      }
      System.out.println();
      for (j = 0; j < nRemainingChars; j++) {
        pos = totalLines * charsPerLine + j;
        System.out.format("%c", interStr[j]);
      }
      System.out.println();
      for (j = 0; j < nRemainingChars; j++) {
        pos = i * charsPerLine + startMiss + j;
        System.out.format("%c", scoreMatrix.amino_acids[outSeq2[nRemainingChars - 1 - j]]);
      }
      System.out.println();
      System.out.println();
    }

    // calc the matching score from the alignment result
    if (Boolean.TRUE) {
      float score = 0.0f;
      int preIsGap = 0;
      int index1Tmp, index2Tmp;
      for (i = 0; i < outLen - startMiss; i++) {
        if (interStr[i] == '|' || interStr[i] == '.') {
          pos = i + startMiss;
          index1Tmp = outSeq1[outLen - 1 - pos];
          index2Tmp = outSeq2[outLen - 1 - pos];
          score += (float)scoreMatrix.blosum62[index1Tmp][index2Tmp];
          preIsGap = 0;
        }
        else {
          if (preIsGap == 0) {
            score = score - openGapPenalty;
          }
          else {
            score = score - extGapPenalty;
          }
          preIsGap = 1;
        }
      }

      System.out.println("In print result function, match score = " + score);
      System.out.println("Output string length = " + (outLen - startMiss));
    }

    return;
  }
}
