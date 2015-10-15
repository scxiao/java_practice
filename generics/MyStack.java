package impl;

public class MyStack<T> {
  private Node<T> head;
  private int size;

  public MyStack() {
    head = null;
    size = 0;
  }

  public void push(T val) {
    Node<T> n = new Node<T>(val);
    n.next = head;
    head = n;
    size++;
  }

  public void pop() {
    if (head != null) {
      head = head.next;
      size--;
    }
  }

  public T top() {
    if (head != null) {
      return head.Value;
    }
    else {
      return null;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return Boolean.TRUE;
    }
    else {
      return Boolean.FALSE;
    }
  }
}

