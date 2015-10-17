import java.util.*;

public class GetKthNum {
  static int KthNum(int n) {
    if (n == 1) {
      return 1;
    }

    Queue<Integer> q3 = new LinkedList<Integer>();
    Queue<Integer> q5 = new LinkedList<Integer>();
    Queue<Integer> q7 = new LinkedList<Integer>();
    q3.add(3);
    q5.add(5);
    q7.add(7);
    int i;
    int num = 0;
    for (i = 2; i <= n; i++) {
      if (q3.peek() < q5.peek() && q3.peek() < q7.peek()) {
        num = q3.remove();
        q3.add(num * 3);
        q5.add(num * 5);
        q7.add(num * 7);
      }
      else if ( q5.peek() < q7.peek() && q5.peek() < q3.peek()) {
        num = q5.remove();
        q5.add(num * 5);
        q7.add(num * 7);
      }
      else {
        num = q7.remove();
        q7.add(num * 7);
      }
      System.out.println("num = " + num);
    }

    return num;
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java GetKthNum n");
      return;
    }

    int n = Integer.parseInt(args[0]);

    System.out.println("The " + n + "th num is:" + KthNum(n));

    return;
  }
}

