import impl.ProxyImage;
import impl.Image;

public class ProxyPatternDemo {
  public static void main(String[] args) {
    Image img = new ProxyImage("testImage.jpg");
    img.display();
    System.out.println("");

    img.display();

    return;
  }
}

