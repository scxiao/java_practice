package impl;

import impl.Order;
import impl.Stock;

public class BuyStock implements Order {
  private Stock abcStock;

  public BuyStock(Stock s) {
    abcStock = s;
  }

  public void execute() {
    abcStock.buy();
  }
}

