import impl.Shape;
import impl.Circle;
import impl.Square;
import impl.RedShapeDecorator;

public class DecoratedPatternDemo {
  public static void main(String[] args) {
    Shape circle = new Circle();

    Shape rc = new RedShapeDecorator(new Circle());

    Shape rr = new RedShapeDecorator(new Square());

    System.out.println("Circle with normal border");
    circle.draw();

    System.out.println("\nCirlce with red border");
    rc.draw();

    System.out.println("\nSquare with red border");
    rr.draw();
  }
}
