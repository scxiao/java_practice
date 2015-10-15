package impl;
import java.util.*;
import java.io.*;
import java.lang.Exception;
import java.lang.Integer;

class Node {
  Node lc;
  Node rc;
  Node p;
  int value;

  Node() {
    lc = rc = null;
    p = null;
    value = 0;
  }

  Node(int val) {
    lc = rc = null;
    p = null;
    value = val;
  }

  Node(int val, Node left, Node right) {
    value = val;
    lc = left;
    rc = right;
  }
}

public class BinaryTree {
  Node root;
  public BinaryTree() {
    root = null;
  }

  public void Create(String fileName) {
    root = null;
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
      String[] words = line.split("\\s+");
      int val = Integer.parseInt(words[0]);
      int loc = Integer.parseInt(words[1]);
      int level = Integer.parseInt(words[2]);
      Node n = new Node(val);
      root = AddNode(root, n, loc, level);
    }

    return;
  }

  public Node AddNode(Node r, Node n, int loc, int level) {
    if (r == null) {
      return n;
    }

    int isLeft = 0;
    int i;
    Node c = r;
    for (i = 0; i < level - 2; i++) {
      isLeft = loc & 1;
      loc = loc >> 1;
      if (c == null) {
        return r;
      }

      if (isLeft == 1) {
        c = c.lc;
      }
      else {
        c = c.rc;
      }
    }

    isLeft = loc & 1;
    if (isLeft == 1) {
      c.lc = n;
    }
    else {
      c.rc = n;
    }
    n.p = c;

    return r;
  }

  public void Print() {
    System.out.println("In order recursive print output:");
    PrintInOrderRecur(root);
    System.out.println();
    System.out.println("In order print output:");
    PrintInOrder(root);
  }

  public void PrintInOrderRecur(Node r) {
    if (r == null) {
      return;
    }

    PrintInOrderRecur(r.lc);
    System.out.println(r.value);
    PrintInOrderRecur(r.rc);

    return;
  }

  public void PrintInOrder(Node r) {
    if (r == null) {
      return;
    }

    // Stack to store node info
    Stack<Node> sn = new Stack<Node>();

    // stack to store # of visits to a node
    Stack<Integer> sc = new Stack<Integer>();

    sn.push(r);
    sc.push(0);

    while (!sn.empty()) {
      Node n = sn.peek();
      int cn = sc.peek().intValue();

      if (cn == 0) { // Visited for the first time
        sc.pop();
        sc.push(1);

        if (n.lc != null) {
          sn.push(n.lc);
          sc.push(0);
        }
      }
      else if (cn == 1) {
        System.out.println(n.value);
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
}
