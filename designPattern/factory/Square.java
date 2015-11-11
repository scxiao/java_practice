package factory;

import factory.Shape;

public class Square implements Shape {
  private double sideLen;

  public Square(double l) {
    sideLen = l;
  }

  public double area() {
    return sideLen * sideLen;
  }

  public void draw() {
    System.out.println("Square, inside draw() function.");
  }
}

