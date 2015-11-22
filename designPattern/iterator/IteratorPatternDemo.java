import impl.NameRepository;
import impl.Iterator;

public class IteratorPatternDemo {
  public static void main(String[] args) {
    NameRepository nr = new NameRepository();
    Iterator iter;
    for (iter = nr.getIterator(); iter.hasNext(); ) {
      String name = (String)iter.next();
      System.out.println("Name : " + name);
    }
  }
}

