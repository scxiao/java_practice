package impl;

import impl.DrawAPI;

public class GreenCircle implements DrawAPI {
  public void drawCircle(double r, double x, double y) {
    System.out.println("In GreenCircle[Color: green, radius: " + r + ", x: " + x + ", y: " + y);
  }
}

