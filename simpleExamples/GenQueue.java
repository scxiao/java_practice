import java.util.LinkedList;

class GenQueue<E> {
  private LinkedList<E> list;

  public GenQueue() {
    list = new LinkedList<E>();
  }

  public void push(E item) {
    list.addLast(item);
  }

  public E back() {
    
  }
