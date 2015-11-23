import java.io.*;
import impl.Alignment;

public class SequenceAlignment {
  private static char[] ReadFile(String fileName) throws IOException {
    FileReader fr = null;
    try {
      File infile = new File(fileName);
      fr = new FileReader(infile);
      BufferedReader br = new BufferedReader(fr);
      char [] buf = new char[(int)infile.length()];
      br.read(buf);

      return buf;
    }
    finally {
      if (fr != null) {
        fr.close();
      }
    }

  }

  public static void main(String[] args) throws IOException {
    if (args.length < 2) {
      System.out.println("Usage: java SequenceAlignment file1 file2 openGapPanelty extGapPenalty");
      return;
    }

    char [] buf1 = ReadFile(args[0]);
    char [] buf2 = ReadFile(args[1]);

    long t1, t2, t3, t4, t5;
    long preprocessingTime, matchTime, traceBackTime;

    float openGapPenalty = 5.0f;
    float extGapPenalty = 0.5f;
    if (args.length == 4) {
      openGapPenalty = Float.parseFloat(args[2]);
      extGapPenalty = Float.parseFloat(args[3]);
    }

    Alignment align = new Alignment(4);
    t1 = System.currentTimeMillis();
    align.setSequences(buf1, buf2);
    t2 = System.currentTimeMillis();
    align.matchString(openGapPenalty, extGapPenalty, 16);
    t3 = System.currentTimeMillis();
    align.printMaxMatchInfo();
    t4 = System.currentTimeMillis();
    align.traceBack();
    t5 = System.currentTimeMillis();
    align.printAlignment(50, openGapPenalty, extGapPenalty);

    preprocessingTime = t2 - t1;
    matchTime = t3 - t2;
    traceBackTime = t5 - t4;
    long totalTime = preprocessingTime + matchTime + traceBackTime;

    System.out.format("Time:\t%d\t%d\t%d\t%d\n", preprocessingTime, matchTime, traceBackTime, totalTime);

    return;
  }
}

