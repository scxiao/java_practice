import impl.MyStack;

public class TestMyStack {
  public static void main(String[] args) {
    MyStack<Integer> ms = new MyStack<Integer>();
    ms.push(1);
    ms.push(2);
    ms.push(3);

    System.out.println("Current stack size = " + ms.size());
    while (!ms.isEmpty()) {
      System.out.println("elem = " + ms.top().intValue());
      ms.pop();
    }

    return;
  }
}
