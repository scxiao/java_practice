import impl.GenQueue;
import java.util.*;

public class TestQueue {
  public static void main(String[] args) {
    GenQueue q = new GenQueue();
    q.push(3);
    q.push("abc");
    q.push(3.21);

    System.out.println("Queue size = " + q.size());
    while (!q.isEmpty()) {
      System.out.println("Elem = " + q.front());
      q.pop();
    }

    return;
  }
}

