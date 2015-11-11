import factory.Shape;
import factory.ShapeFactory;

public class TestShape {
  public static void main(String[] args) {
    ShapeFactory sf = new ShapeFactory();
    Shape c = sf.getShape("Circle", 1.0);
    c.draw();
    System.out.println("Circle area = " + c.area());

    Shape s = sf.getShape("Square", 1.0);
    s.draw();
    System.out.println("Square area = " + s.area());

    return;
  }
}

