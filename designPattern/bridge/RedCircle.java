package impl;

import impl.DrawAPI;

public class RedCircle implements DrawAPI {
  public void drawCircle(double r, double x, double y) {
    System.out.println("In RedCircle[Color: red, radius: " + r + ", x: " + x + ", y: " + y);
  }
}

