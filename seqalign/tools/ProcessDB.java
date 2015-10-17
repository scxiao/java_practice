import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.Vector;
import java.nio.ByteBuffer;
import impl.ScoreMatrix;

class SeqInfo {
  int descrStartPos;
  int descrSize;
  int seqSize;

  public SeqInfo(int dPos, int dSize, int sSize) {
    descrStartPos = dPos;
    descrSize = dSize;
    seqSize = sSize;
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
        int offset = 0;
        Vector<SeqInfo> seqInfoVec = new Vector<SeqInfo>();
        File seqFile = new File(args[0]);
        fr = new FileReader(seqFile);
        br = new BufferedReader(fr);

        // open output file
        File locFile = new File(locFileName);
        locFs = new FileOutputStream(locFile);

        File dataFile = new File(dataFileName);
        dataFs = new FileOutputStream(dataFile);

        String line;
        int seqIndex = 0;
        while ((line = br.readLine()) != null) {
          char tmp = line.charAt(0);
          if (tmp == '>') {
            int descrpSize = line.length();
            String seq = br.readLine();
            if (seq == null) {
              continue;
            }
            int seqSize = seq.length();

            SeqInfo info = new SeqInfo(offset, descrpSize, seqSize);
            seqInfoVec.addElement(info);

            char[] seqArray = seq.toCharArray();
            sm.encoding(seqArray);
            byte[] seqByteArray = new byte[seqArray.length];
            for (int i = 0; i < seqArray.length; i++) {
              seqByteArray[i] = (byte)seqArray[i];
            }

            System.out.println("seqIndex = " + seqIndex++);

            // Write info to the output file
            byte[] sizeByte = ByteBuffer.allocate(4).putInt(seqSize).array();

            // Write size to the loc file
            locFs.write(sizeByte);

            // Write seq to the data file
            dataFs.write(seqByteArray);
          }
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

