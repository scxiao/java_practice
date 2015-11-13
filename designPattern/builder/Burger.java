package impl;

import impl.Item;
import impl.Packing;

public abstract class Burger implements Item {
  public Packing packing() {
    return new Wrapper();
  }

//  public abstract float price();
}
