package impl;

import impl.Stock;
import impl.Order;
import impl.SellStock;

public class SellStock implements Order {
  private Stock abcStock;

  public SellStock(Stock s) {
    abcStock = s;
  }

  public void execute() {
    abcStock.sell();
  }
}

