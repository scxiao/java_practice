import java.util.ArrayDeque;

class KthNumber {
  private ArrayDeque<Integer> qu3;
  private ArrayDeque<Integer> qu5;
  private ArrayDeque<Integer> qu7;

  KthNumber() {
    qu3 = new ArrayDeque<Integer>();
    qu5 = new ArrayDeque<Integer>();
    qu7 = new ArrayDeque<Integer>();
  }

  public int getNumber(int n) {
    qu3.clear();
    qu5.clear();
    qu7.clear();
    qu3.add(3);
    qu5.add(5);
    qu7.add(7);

    int i, res = 1;
    for (i = 0; i < n; i++) {
      int n3 = qu3.getFirst().intValue();
      int n5 = qu5.getFirst().intValue();
      int n7 = qu7.getFirst().intValue();
      if (n3 < n5 && n3 < n7) { // n3 is smallest
        res = qu3.remove();
        qu3.add(3 * res);
        qu5.add(5 * res);
        qu7.add(7 * res);
      }
      else if (n5 < n3 && n5 < n7) {
        res = qu5.remove();
        qu5.add(5 * res);
        qu7.add(7 * res);
      }
      else {
        res = qu7.remove();
        qu7.add(7 * res);
      }
    }

    return res;
  }
}

public class TestGetKthNum {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: Java TestGetKthNum n");
      return;
    }

    int n = Integer.parseInt(args[0]);
    KthNumber kn = new KthNumber();
    int res = kn.getNumber(n);
    int res1 = kn.getNumber(n+1);

    System.out.println(n + "th number is " + res);
    System.out.println((n+1) + "th number is " + res1);

    return;
  }
}

