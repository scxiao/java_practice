import impl.BinarySearchTree;

public class TestBST {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("java TestBST file");
      return;
    }

    BinarySearchTree tree = new BinarySearchTree();
    tree.Create(args[0]);
    System.out.println("Tree height = " + tree.GetHeight());
    tree.Print();

    return;
  }
}

