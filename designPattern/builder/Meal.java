package impl;

import impl.Item;
import java.util.List;
import java.util.ArrayList;

public class Meal {
  private List<Item> list = new ArrayList<Item>();

  public void addItem(Item e) {
    list.add(e);
  }

  public float getCost() {
    float cost = 0;
    for (Item item : list) {
      cost += item.price();
    }

    return cost;
  }

  public void showItems() {
    for (Item item : list) {
      System.out.print("Item : " + item.name());
      System.out.print(", Packing: " + item.packing().pack());
      System.out.println(", price: " + item.price());
    }
  }
}

