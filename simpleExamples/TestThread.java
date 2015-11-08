class PrintDemo {
  public void printCount() {
    try {
      for (int i = 50; i >= 0; i--) {
        System.out.println("Counter ---- " + i);
      }
    }
    catch (Exception e) {
      System.out.println("Thread interrupted.");
    }
  }
}

class ThreadDemo extends Thread {
  private Thread t;
  private String threadName;
  private PrintDemo PD;

  ThreadDemo(String name, PrintDemo pd) {
    threadName = name;
    PD = pd;
  }

  public void run() {
    synchronized(PD) {
      PD.printCount();
    }
    System.out.println("Thread " + threadName + " exited ...");
  }

  public void start() {
    System.out.println("Thread " + threadName + " started...");
    if (t == null) {
      t = new Thread(this, threadName);
      t.start();
    }
  }
}

public class TestThread {
  public static void main(String[] args) {
    PrintDemo pd = new PrintDemo();

    ThreadDemo t1 = new ThreadDemo("Thread-1", pd);
    ThreadDemo t2 = new ThreadDemo("Thread-2", pd);

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    }
    catch (Exception e) {
      System.out.println("Thread interrupted.");
    }
  }
}


