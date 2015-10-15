package impl;

class Node<T> {
  T Value;
  Node<T> next, prev;
  Node(T val) {
    Value = val;
    next = prev = null;
  }
}

public class MyLinkedList<T> {
  Node<T> head, tail;
  int m_nNodeNum;

  MyLinkedList() {
    head = tail = null;
    m_nNodeNum = 0;
  }

  public int size() {
    return m_nNodeNum;
  }

  private void AddNode(Node n) {
    if (head == null) {
      head = tail = n;
    }
    else {
      tail.prev = n;
      n.next = tail;
      tail = n;
    }

    return;
  }

  private boolean RemoveNode() {
    if (head == null) {
      return Boolean.FALSE;
    }

    if (head == tail) { // only one node
      head = tail = null;
    }
    else {
      tail = tail.prev;
      tail.next = null;
    }

    return Boolean.TRUE;
  }

  public boolean isEmpty() {
    if (m_nNodeNum == 0) {
      return Boolean.TRUE;
    }
    else {
      return Boolean.FALSE;
    }
  }

  public void push(T val) {
    Node<T> n = new Node<T>(val);
    AddNode(n);
  }

  public T top() {
    if (tail != null) {
      return tail.Value;
    }

    return tail.Value;
  }

  public void pop() {
    RemoveNode();
  }
}

