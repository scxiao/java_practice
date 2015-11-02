package impl;

import java.util.LinkedList;

public class GenQueue<E> implements java.io.Serializable {
  private LinkedList<E> list;

  public GenQueue() {
    list = new LinkedList<E>();
  }

  public void push(E item) {
    list.addLast(item);
  }

  public void pop() {
    list.poll();
  }

  public E front() {
    return list.peek();
  }

  public E back() {
    return list.peekLast();
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}

