import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import impl.ScoreMatrix;

public class GenSequence {
  public static void main(String[] args) throws IOException {
    if (args.length != 3) {
      System.out.println("Usage: java GenSequence fileName seq# seqSize");
      return;
    }

    int seqNum = Integer.parseInt(args[1]);
    if (seqNum <= 0) {
      return;
    }

    int seqSize = Integer.parseInt(args[2]);
    if (seqSize <= 0) {
      return;
    }

    ScoreMatrix sm = new ScoreMatrix();
    Random rm = new Random();


    File file = null;
    FileWriter fw = null;

    try {
      file = new File(args[0]);
      fw = new FileWriter(file);

      char[] seq = new char[seqSize];
      int i, j;
      for (i = 0; i < seqNum; i++) {
        for (j = 0; j < seqSize; j++) {
          int index = rm.nextInt(23);
          seq[j] = sm.amino_acids[index];
        }

        // Write to output file
        String dscrp = ">lcl|" + i + "\n";
        String seqStr = new String(seq);
        seqStr = seqStr + "\n";

        fw.write(dscrp);
        fw.write(seqStr);
      }
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    finally {
      if (fw != null) {
        fw.close();
      }
    }
  }
}
