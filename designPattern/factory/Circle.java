package factory;

import factory.Shape;

public class Circle implements Shape {
  private double radius;
  private static final double Pi = 3.14159265;

  Circle (double r) {
    radius = r;
  }

  public double area() {
    return Pi * radius * radius;
  }

  public void draw() {
    System.out.println("Circle, inside draw() function.");
  }
}


