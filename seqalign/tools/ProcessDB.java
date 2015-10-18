import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.ByteBuffer;
import java.util.Collections;
import impl.ScoreMatrix;

class SeqInfo implements Comparable<SeqInfo> {
  long offset;
  int descrSize;
  int seqSize;

  public SeqInfo(long dPos, int dSize, int sSize) {
    offset = dPos;
    descrSize = dSize;
    seqSize = sSize;
  }

  public int compareTo(SeqInfo si) {
    int size = si.seqSize;
    return size - this.seqSize;
  }
}

public class ProcessDB {

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Usage: java ProcessDB dbname read(0)/format(1)");
      return;
    }

    // Get a score matrix instance
    ScoreMatrix sm = new ScoreMatrix();
    FileReader fr = null;
    FileOutputStream dataFs, locFs;
    BufferedReader br;
    br = null;
    dataFs = locFs = null;

    String locFileName = args[0] + ".loc";
    String dataFileName = args[0] + ".data";

    int flag = Integer.parseInt(args[1]);
    if (flag == 1) { // format DB
      try {
        // Open input file
        ArrayList<SeqInfo> seqInfoList = new ArrayList<SeqInfo>();
        File seqFile = new File(args[0]);
        RandomAccessFile raf = new RandomAccessFile(seqFile, "r");

        // open output file
        File locFile = new File(locFileName);
        locFs = new FileOutputStream(locFile);

        File dataFile = new File(dataFileName);
        dataFs = new FileOutputStream(dataFile);

        String line;
        int seqIndex = 0;
        while ((line = raf.readLine()) != null) {
          char tmp = line.charAt(0);
          if (tmp == '>') {
            int descrpSize = line.length();
            long offset = raf.getFilePointer();
            String seq = raf.readLine();
            if (seq == null) {
              continue;
            }
            int seqSize = seq.length();

            SeqInfo info = new SeqInfo(offset, descrpSize, seqSize);
            seqInfoList.add(info);
          }
        }

        // Sort all the sequences according to their size
        // from longest to shortest
        Collections.sort(seqInfoList);

        int i;
        for (i = 0; i < seqInfoList.size(); i++) {
          System.out.println("SeqIndex = " + i);
          SeqInfo si = seqInfoList.get(i);
          // Seek to the correct position
          raf.seek(si.offset);
          String seq = raf.readLine();

          char[] seqArray = seq.toCharArray();
          sm.encoding(seqArray);
          byte[] seqByteArray = new byte[seqArray.length];
          for (int j = 0; j < seqArray.length; j++) {
            seqByteArray[j] = (byte)seqArray[j];
          }


          // Write info to the output file
          byte[] sizeByte = ByteBuffer.allocate(4).putInt(si.seqSize).array();

          // Write size to the loc file
          locFs.write(sizeByte);

          // Write seq to the data file
          dataFs.write(seqByteArray);
        }
      }
      finally {
        if (fr != null) {
          fr.close();
        }

        if (br != null) {
          br.close();
        }

        if (locFs != null) {
          locFs.close();
        }

        if (dataFs != null) {
          dataFs.close();
        }
      }
    }
    else { // read database
      File locFile = new File(locFileName);
      InputStream locInFs = new FileInputStream(locFile);

      File dataFile = new File(dataFileName);
      InputStream dataInFs = new FileInputStream(dataFile);

      byte[] seqSizeArray = new byte[4];
      int seqIndex = 0;
      while (Boolean.TRUE) {
        int readSize = locInFs.read(seqSizeArray);
        if (readSize <= 0) {
          break;
        }

        // Convert byte array to int
        ByteBuffer wrap = ByteBuffer.wrap(seqSizeArray);
        int seqSize = wrap.getInt();

        byte[] seq = new byte[seqSize];
        dataInFs.read(seq);

        // Print the seq
        int i;
        System.out.println("Seq: " + seqIndex++ + ", size = " + seqSize);
        for (i = 0; i < seqSize; i++) {
          System.out.format("%c", sm.amino_acids[(int)seq[i]]);
        }
        System.out.println();
      }
    }

    return;
  }
}

