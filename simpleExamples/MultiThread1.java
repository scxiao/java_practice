
class Worker implements Runnable {
  private int threadId;
  private Thread t;

  public Worker(int id) {
    threadId = id;
  }

  public void run() {
    System.out.println("In thread: " + threadId);
    return;
  }

  public void start() {
    t = new Thread(this, Integer.toString(threadId));
    t.start();
  }
}

public class MultiThread1 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: Java MultiThread #ofThread");
      return;
    }

    int n = Integer.parseInt(args[0]);

    for (int i = 0; i < n; i++) {
      Worker item = new Worker(i);
      item.start();
    }
  }
}
