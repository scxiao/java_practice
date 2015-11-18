package impl;

import impl.Shape;

public class Circle implements Shape {
  private int x, y, radius;
  private String color;

  public Circle(String color) {
    this.color = color;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setRadius(int r) {
    radius = r;
  }

  public void draw() {
    System.out.println("Circle, draw() [color: " + color +
        ", x: " + x +
        ", y: " + y +
        ", radius: " + radius);
  }
}

