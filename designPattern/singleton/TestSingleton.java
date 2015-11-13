import impl.Singleton;

public class TestSingleton {
  public static void main(String[] args) {
    Singleton obj = Singleton.getInstance();
    obj.print();
  }
}

