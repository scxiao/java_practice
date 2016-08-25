import java.util.*;
import java.io.*;

public class TestSetColor {
  public static void sortColors(int[] nums) {
    if (nums.length <= 1) {
      return;
    }

    int[] count = new int[3];
    int i;
    for (i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }
    count[1] += count[0];
    count[2] += count[1];

    int redIndex = 0;
    int whiteIndex = count[0];
    int blueIndex = count[1];

    for (i = 0; i < nums.length;) {
      System.out.println("nums[" + i + "] = " + nums[i]);
      if (nums[i] == 0) {
        if (i < count[0]) {
          i++;
        }
        else {
          int tmp = nums[redIndex];
          nums[redIndex] = nums[i];
          nums[i] = tmp;
        }
        redIndex++;
      }
      else if (nums[i] == 1) {
        if (i >= count[0] && i < count[1]) {
          i++;
        }
        else {
          System.out.println("whiteIndex = " + whiteIndex);
          int tmp = nums[whiteIndex];
          nums[whiteIndex] = nums[i];
          nums[i] = tmp;
        }
        whiteIndex++;
      }
      else {
        if (i >= count[1]) {
          i++;
        }
        else {
          int tmp = nums[blueIndex];
          nums[blueIndex] = nums[i];
          nums[i] = tmp;
        }
        blueIndex++;
      }
    }

    return;
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: TestSetColor file");
      return;
    }

    Vector<Integer> vecNums = new Vector<Integer>();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(args[0]));
      while (true) {
        String line = br.readLine();
        if (line == null) {
          break;
        }
        vecNums.add(Integer.parseInt(line));
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }

    System.out.println("Input info:");
    Iterator it = vecNums.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    int [] colorArray = new int[vecNums.size()];
    for (int i = 0; i < vecNums.size(); i++) {
      colorArray[i] = vecNums.get(i).intValue();
    }

    sortColors(colorArray);

    System.out.println("After sort:");
    for (int i = 0; i < colorArray.length; i++) {
      System.out.println(colorArray[i]);
    }

    return;
  }
}
