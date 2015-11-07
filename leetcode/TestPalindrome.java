public class TestPalindrome {
  public static String longestPalindrome(String s) {
    String convertedStr = "^#";
    int i;
    for (i = 0; i < s.length(); i++) {
      convertedStr += s.charAt(i);
      convertedStr += '#';
    }
    convertedStr += '$';

    int[] p = new int[convertedStr.length()];
    int c = 0;
    int r = 0;
    for (i = 0; i < convertedStr.length(); i++) {
      p[i] = 0;
    }

    for (i = 1; i < convertedStr.length() - 1; i++) {
      int iMirror = 2 * c - i;
      if (r > i) {
        p[i] = Math.min(r - i, p[iMirror]);
      }
      else {
        p[i] = 0;
      }

      while (convertedStr.charAt(i + 1 + p[i]) == convertedStr.charAt(i - 1 - p[i])) {
        p[i]++;
      }

      if (r < i + p[i]) {
        r = i + p[i];
        c = i;
      }
    }

    int maxLen = 0;
    int centerIndex = 0;
    for (i = 1; i < convertedStr.length(); i++) {
      if (maxLen < p[i]) {
        maxLen = p[i];
        centerIndex = i;
      }
    }

    int startPos = (centerIndex - 1 - maxLen) / 2;
    return s.substring(startPos, startPos + maxLen);
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java TestPlindrome str");
      return;
    }

    String res = longestPalindrome(args[0]);

    System.out.println("res = " + res);

    return;
  }
}

