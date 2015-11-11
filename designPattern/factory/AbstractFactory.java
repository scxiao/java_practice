package factory;

import factory.Shape;
import factory.Color;

public abstract class AbstractFactory {
  public abstract Shape getShape(String shapeType, double size);
  public abstract Color getColor(String color);
}

