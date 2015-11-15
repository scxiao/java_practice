package impl;

import impl.DrawAPI;

public abstract class Shape {
  protected DrawAPI drawApi;

  public Shape(DrawAPI da) {
    drawApi = da;
  }

  public abstract void draw();
}

