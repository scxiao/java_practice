import impl.Broker;
import impl.Stock;
import impl.BuyStock;
import impl.SellStock;

public class CommandPatternDemo {
  public static void main(String[] args) {
    Stock stock = new Stock();

    BuyStock bs = new BuyStock(stock);
    SellStock ss = new SellStock(stock);

    Broker bk = new Broker();
    bk.takeOrder(bs);
    bk.takeOrder(ss);

    bk.placeOrders();

    return;
  }
}

