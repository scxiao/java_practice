
class Counter extends Thread {
  private Thread t;
  private int threadNo;
  private String threadName;

  Counter(int tid, String name) {
    threadNo = tid;
    threadName = name;
  }

  public synchronized void run() {
    if (threadNo == 0) {
      try {
      System.out.println("Wait on notify ...");
      t.wait();
      System.out.println("Notified ...");
      int i;
      for (i = 5; i >= 0; i--) {
        System.out.println("Counter --- " + i);
      }
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    else {
      System.out.println("Notify ...");
      t.notify();
    }
  }

  public void start() {
    if (t == null) {
      t = new Thread(this, threadName);
      t.start();
    }
  }
}

public class TestWaitNotify {
  public static void main(String[] args) {
    Counter c1 = new Counter(0, "Counter...");
    Counter c2 = new Counter(1, "Starter...");

    c1.start();
    c2.start();

    try {
      c1.join();
      c2.join();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}



