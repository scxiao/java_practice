import factory.Shape;
import factory.Color;
import factory.AbstractFactory;
import factory.FactoryProducer;

public class FactoryPatternDemo {
  public static void main(String[] args) {
    AbstractFactory sf = FactoryProducer.getFactory("shape");

    Shape sq = sf.getShape("Square", 1.0);
    Shape ci = sf.getShape("Circle", 1.0);
    System.out.println("Square area = " + sq.area());
    sq.draw();

    System.out.println("Circle area = " + ci.area());
    ci.draw();

    AbstractFactory cf = FactoryProducer.getFactory("color");
    Color r = cf.getColor("red");
    Color g = cf.getColor("green");
    Color b = cf.getColor("blue");
    r.fill();
    g.fill();
    b.fill();

    return;
  }
}

