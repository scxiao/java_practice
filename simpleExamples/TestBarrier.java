import java.util.concurrent.CyclicBarrier;

class Counter extends Thread {
  private String threadName;
  private Thread t;
  private CyclicBarrier barrier;

  Counter(String name, CyclicBarrier ba) {
    threadName = name;
    barrier = ba;
  }

  public void run() {
    System.out.println("Start run in " + threadName);
    try {
      barrier.await();
      int i;
      for (i = 10; i >= 0; i--) {
        System.out.println(threadName + " prints " + i);
        barrier.await();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void start() {
    if (t == null) {
      t = new Thread(this, threadName);
    }
    t.start();
  }
}

public class TestBarrier {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: Java TestBarrier n");
      return;
    }

    int threadNum = Integer.parseInt(args[0]);

    CyclicBarrier cb = new CyclicBarrier(threadNum);
    Counter[] cnt;
    cnt = new Counter[threadNum];

    int i;
    for (i = 0; i < threadNum; i++) {
      String tName = "Thread-" + i;
      cnt[i] = new Counter(tName, cb);
      cnt[i].start();
    }

    for (i = 0; i < threadNum; i++) {
      cnt[i].join();
    }

    return;
  }
}

