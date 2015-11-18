package impl;

public class Stock {
  private String name = "ABC";
  private int quantity = 100;

  public void buy() {
    System.out.println("Stock [name: " + name + ", Quantity: " + quantity + "] bought");
  }

  public void sell() {
    System.out.println("Stock [name: " + name + ", Quantity: " + quantity + "] sold");
  }
}

