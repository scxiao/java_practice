package impl;

import impl.Order;
import java.util.List;
import java.util.ArrayList;

public class Broker {
  private List<Order> ls = new ArrayList<Order>();

  public void takeOrder(Order order) {
    ls.add(order);
  }

  public void placeOrders() {
    for (Order order : ls) {
      order.execute();
    }
  }
}

