class Box<T> {
  // T stands for "Type"
  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }
}

public class TestBox {
  public static void main(String[] args) {
    Box<Integer> bi = new Box<Integer>();
    bi.set(2);
    int output = bi.get().intValue();
    System.out.println("output = " + output);
    return;
  }
}

