import impl.RedCircle;
import impl.GreenCircle;
import impl.Circle;
import impl.Shape;

public class BridgePatternDemo {
  public static void main(String[] args) {
    Shape redCircle = new Circle(100, 100, 10, new RedCircle());
    Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

    redCircle.draw();
    greenCircle.draw();

    return;
  }
}

