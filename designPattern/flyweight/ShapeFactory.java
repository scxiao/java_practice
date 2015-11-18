package impl;

import impl.Shape;
import impl.Circle;
import java.util.HashMap;

public class ShapeFactory {
  private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

  public static Shape getCircle(String color) {
    Circle c = (Circle)circleMap.get(color);
    if (c == null) {
      c = new Circle(color);
      circleMap.put(color, c);
      System.out.println("Create circle of color: " + color);
    }

    return c;
  }
}

