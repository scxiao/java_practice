package factory;

import factory.Shape;
import factory.Color;
import factory.Red;
import factory.Green;
import factory.Blue;

public class ColorFactory extends AbstractFactory {
  public Color getColor(String color) {
    if (color == null) {
      return null;
    }

    if (color.equalsIgnoreCase("red")) {
      return new Red();
    }
    else if (color.equalsIgnoreCase("green")) {
      return new Green();
    }
    else if (color.equalsIgnoreCase("blue")) {
      return new Blue();
    }
    else {
      return null;
    }
  }

  public Shape getShape(String shapeType, double size) {
    return null;
  }
}

