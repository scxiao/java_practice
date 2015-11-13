package impl;

public class Singleton {
  private static Singleton instance = new Singleton();

  private Singleton() { }

  public static Singleton getInstance() {
    return instance;
  }

  public void print() {
    System.out.println("This is the singleton print() function.");
  }
}

