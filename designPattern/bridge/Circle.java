package impl;

import impl.Shape;
import impl.DrawAPI;

public class Circle extends Shape {
  private double r, x, y;

  public Circle(double x, double y, double r, DrawAPI da) {
    super(da);
    this.r = r;
    this.x = x;
    this.y = y;
  }

  public void draw() {
    drawApi.drawCircle(r, x, y);
  }
}

