package factory;

import factory.Shape;
import factory.Circle;
import factory.Square;
import factory.Color;
import factory.AbstractFactory;

public class ShapeFactory extends AbstractFactory {
  public Color getColor(String color) {
    return null;
  }

  public Shape getShape(String shapeName, double size) {
    if (shapeName == null) {
      return null;
    }
    else if (shapeName.equalsIgnoreCase("Circle")) {
      return new Circle(size);
    }
    else if (shapeName.equalsIgnoreCase("Square")) {
      return new Square(size);
    }
    else {
      return null;
    }
  }
}

