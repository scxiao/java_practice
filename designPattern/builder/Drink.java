package impl;

import impl.Item;
import impl.Bottle;
import impl.Packing;

public abstract class Drink implements Item {
  public Packing packing() {
    return new Bottle();
  }

  // public abstract float price();
}

