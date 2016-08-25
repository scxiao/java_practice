import java.util.Scanner;
import java.io.*;


public class TestDataCheck {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java TestDataCheck infile");
      return;
    }

    File infile = null;
    Scanner console = null;
    try {
      infile = new File(args[0]);
      console = new Scanner(infile);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Scanner lineTokenizer;
    int lineNum = 0;

    while (console.hasNextLine()) {
      String line = console.nextLine();
      lineTokenizer = new Scanner(line);
      lineNum++;

      if (lineTokenizer.hasNext()) {
        lineTokenizer.next();
      }
      else {
        System.out.printf("Line %d: line must have the format 'name age singleness'\n", 
            lineNum);
        continue;
      }

      if (lineTokenizer.hasNext()) {
        if (lineTokenizer.hasNextInt()) {
          lineTokenizer.nextInt();
        }
        else {
          System.out.printf("Line %d: age should be an integer\n",
              lineNum, lineTokenizer.next());
        }
      }
      else {
        System.out.printf("Line %d: must have fields for age and singleness\n",
            lineNum);
        continue;
      }

      if (lineTokenizer.hasNext()) {
        if (lineTokenizer.hasNextBoolean()) {
          lineTokenizer.nextBoolean();
        }
        else {
          System.out.printf("Line %d - %s: singleness should be a boolean\n",
              lineNum, lineTokenizer.next());
          continue;
        }
      }
      else {
        System.out.printf("Line %d: must have a field for singleness\n",
            lineNum);
        continue;
      }
      lineTokenizer.close();
    }
  }
}

