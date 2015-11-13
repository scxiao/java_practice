package impl;

import java.util.Hashtable;
import impl.Square;
import impl.Circle;
import impl.Rectangle;

public class ShapeCache {
  private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

  public static Shape getShape(String shapeId) {
    Shape cachedShape = shapeMap.get(shapeId);

    return (Shape)cachedShape.clone();
  }

  // for each shape, run database query and create shape
  // shapeMap.push
  public static void loadCache() {
    Circle circle = new Circle();
    circle.setId("1");
    shapeMap.put(circle.getId(), circle);

    Square square = new Square();
    square.setId("2");
    shapeMap.put(square.getId(), square);

    Rectangle rec = new Rectangle();
    rec.setId("3");
    shapeMap.put(rec.getId(), rec);
  }
}
