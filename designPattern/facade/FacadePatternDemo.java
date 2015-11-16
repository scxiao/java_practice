import impl.ShapeMaker;

public class FacadePatternDemo {
  public static void main(String[] args) {
    ShapeMaker sm = new ShapeMaker();

    sm.drawCircle();
    sm.drawSquare();
    sm.drawRectangle();
  }
}

