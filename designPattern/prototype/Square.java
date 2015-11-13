package impl;

import impl.Shape;

public class Square extends Shape {
  public Square() {
    type = "Square";
  }

  public void draw() {
    System.out.println("Squre, in draw() function.");
  }
}

