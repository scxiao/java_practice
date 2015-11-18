package impl;

import impl.Image;
import impl.RealImage;

public class ProxyImage implements Image {
  private RealImage ri;
  private String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  public void display() {
    if (ri == null) {
      ri = new RealImage(fileName);
    }
    ri.display();
  }
}

