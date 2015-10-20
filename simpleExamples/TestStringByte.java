import java.util.*;

public class TestStringByte {
  public static void main(String[] args) {
    String str = "abcedfgdh";
    byte[] byteArray = str.getBytes();
    System.out.println("byte array size = " + byteArray.length);

    String str1 = new String(byteArray);
    System.out.println(str1);

    return;
  }
}

