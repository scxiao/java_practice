import impl.Shape;
import impl.Circle;
import impl.ShapeFactory;

public class FlyweightPatternDemo {
  private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

  public static void main(String[] args) {
    int i;
    for (i = 0; i < 20; i++) {
      Circle c = (Circle)ShapeFactory.getCircle(getRandomColor());
      c.setX(getRandomX());
      c.setY(getRandomY());
      c.setRadius(100);
      c.draw();
    }
  }

  private static String getRandomColor() {
    return colors[(int)(Math.random() * colors.length)];
  }

  private static int getRandomX() {
    return (int)(Math.random() * 100);
  }

  private static int getRandomY() {
    return (int)(Math.random() * 100);
  }
}

