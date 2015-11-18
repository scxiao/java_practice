package impl;

import impl.Iterator;
import impl.Container;

public class NameRepository implements Container {
  String[] names = {"Julie", "John", "Robert", "Lora"};

  public Iterator getIterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator {
    int index = 0;

    public boolean hasNext() {
      if (index < names.length) {
        return true;
      }

      return false;
    }

    public Object next() {
      if (this.hasNext()) {
        return names[index++];
      }

      return null;
    }
  }
}

