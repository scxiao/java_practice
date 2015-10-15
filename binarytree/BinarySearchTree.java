package impl;
import java.util.*;
import java.io.*;
import java.lang.Exception;
import java.lang.Integer;

public class BinarySearchTree {
  Node root;
  public BinarySearchTree() {
    root = null;
  }

  // Create binary search tree from a file
  public void Create(String fileName) {
    Scanner sc = null;
    try {
      sc = new Scanner(new File(fileName));
    }
    catch (FileNotFoundException fe) {
      fe.printStackTrace();
    }

    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      System.out.println(line);
      String [] words = line.split("\\s+");
      int i;
      for (i = 0; i < words.length; i++) {
        int val = Integer.parseInt(words[i]);
        root = AddNode(root, val);
      }
    }

    return;
  }

  // Add node to the tree
  public Node AddNode(Node r, int val) {
    Node n = new Node(val);
    if (r == null) {
      return n;
    }

    Node root_backup = r;
    Node p = r;
    while (r != null) {
      p = r;
      if (r.value >= val) {
        r = r.lc;
      }
      else {
        r = r.rc;
      }
    }

    if (p.value >= val) {
      p.lc = n;
    }
    else {
      p.rc = n;
    }
    n.p = p;

    // Rebalance the binary search tree
    root_backup = TreeBalance(p);

    return root_backup;
  }

  // Print the binary search tree
  public void Print() {
    System.out.println("In order recursive print output:");
    PrintPreOrderRecur(root);
    System.out.println();
    System.out.println("In order print output:");
    PrintPreOrder(root);
    System.out.println("Level order print output:");
    PrintLevel(root);
    return;
  }

  // Print BST in pre-order using recursive implementation
  private void PrintPreOrderRecur(Node r) {
    if (r == null) {
      return;
    }

    System.out.println(r.value);
    PrintPreOrderRecur(r.lc);
    PrintPreOrderRecur(r.rc);
  }

  // Print BST in pre-order using non-recursive implementation
  private void PrintPreOrder(Node r) {
    if (r == null) {
      return;
    }

    Stack<Node> sn = new Stack<Node>();
    Stack<Integer> sc = new Stack<Integer>();

    sn.push(r);
    sc.push(0);

    while (!sn.empty()) {
      Node n = sn.peek();
      int count = sc.peek().intValue();

      if (count == 0) {
        System.out.println(n.value);
        sc.pop();
        sc.push(1);

        if (n.lc != null) {
          sn.push(n.lc);
          sc.push(0);
        }
      }
      else if (count == 1) {
        sn.pop();
        sc.pop();

        if (n.rc != null) {
          sn.push(n.rc);
          sc.push(0);
        }
      }
    }

    return;
  }

  private void PrintLevel(Node r) {
    if (r == null) {
      return;
    }

    Queue<Node> nl = new LinkedList<Node>();
    nl.add(r);
    nl.add(null);
    while (!nl.isEmpty()) {
      Node n = nl.remove();
      if (n == null) {
        if (nl.isEmpty()) {
          break;
        }
        nl.add(null);
        System.out.println();
      }
      else {
        System.out.format("%d\t", n.value);
        if (n.lc != null) {
          nl.add(n.lc);
        }

        if (n.rc != null) {
          nl.add(n.rc);
        }
      }
    }

    return;
  }


  private int GetHeight(Node r) {
    if (r == null) {
      return 0;
    }

    int left_height = 1;
    int right_height = 1;

    if (r.lc != null) {
      left_height = 1 + GetHeight(r.lc);
    }

    if (r.rc != null) {
      right_height = 1 + GetHeight(r.rc);
    }

    return (left_height > right_height) ? left_height : right_height;
  }

  public int GetHeight() {
    return GetHeight(root);
  }

  private int BalanceFactor(Node r) {
    if (r == null) {
      return 0;
    }

    int left_height = GetHeight(r.lc);
    int right_height = GetHeight(r.rc);

    return left_height - right_height;
  }

  private Node LeftRotation(Node r) {
    // Child change
    Node tmp = r.rc;
    tmp.p = r.p;

    r.rc = tmp.lc;
    if (r.rc != null) {
      r.rc.p = r;
    }

    tmp.lc = r;
    r.p = tmp;

    r = tmp;

    return r;
  }

  private Node RightRotation(Node r) {
    Node tmp = r.lc;
    tmp.p = r.p;

    r.lc = tmp.rc;
    if (r.lc != null) {
      r.lc.p = r;
    }

    tmp.rc = r;
    r.p = tmp;

    r = tmp;

    return r;
  }

  private Node NodeBalance(Node n) {
    if (n == null) {
      return null;
    }

    int factor = BalanceFactor(n);
    if (factor == -2) {
      Node rc = n.rc;
      if (BalanceFactor(rc) == 1) {
        n.rc = RightRotation(rc);
      }
      return LeftRotation(n);
    }
    else if (factor == 2) {
      Node lc = n.lc;
      if (BalanceFactor(lc) == -1) {
        n.lc = LeftRotation(lc);
      }
      return RightRotation(n);
    }

    return n;
  }

  private Node TreeBalance(Node n) {
    if (n == null) {
      return null;
    }

    Node r = n;
    while (n != null) {
      int flag = 0; // 1 left child, 2 right child;
      Node p = n.p;
      if (p != null) {
        if (p.lc == n) {
          flag = 1;
        }
        else {
          flag = 2;
        }
      }
      n = NodeBalance(n);
      if (flag == 1) {
        p.lc = n;
      }
      else if (flag == 2) {
        p.rc = n;
      }
      r = n;
      n = p;
    }

    return r;
  }
}

