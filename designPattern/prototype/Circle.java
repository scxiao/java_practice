package impl;

import impl.Shape;

public class Circle extends Shape {
  public Circle() {
    type = "Circle";
  }

  public void draw() {
    System.out.println("Circle, in draw() function.");
  }
}

