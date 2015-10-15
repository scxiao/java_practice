import impl.BinaryTree;
public class TestBinaryTree {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java TestBinaryTree file");
      return;
    }

    BinaryTree bt = new BinaryTree();
    bt.Create(args[0]);
    bt.Print();

    return;
  }
}
