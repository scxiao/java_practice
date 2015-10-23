class Worker extends Thread {
  private int threadId;
  private Thread t;

  Worker(int id) {
    threadId = id;
  }

  public void run() {
    System.out.println("In thread: " + threadId);
    return;
  }

  public void start() {
    t = new Thread(this);
    t.start();
  }
}

public class MultiThread2 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java MulthThread2 Thread#");
      return;
    }

    int n = Integer.parseInt(args[0]);

    int i;
    for (i = 0; i < n; i++) {
      Worker w = new Worker(i);
      w.start();
    }

    return;
  }
}

