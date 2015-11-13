package impl;

import impl.Shape;

public class Rectangle extends Shape {
  public Rectangle() {
    type = "Retangle";
  }

  public void draw() {
    System.out.println("Retangle, in draw() function");
  }
}

