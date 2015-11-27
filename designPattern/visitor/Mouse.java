package impl;

import impl.ComputerPart;
import impl.ComputerPartVisitor;

public class Mouse implements ComputerPart {
  public void accept(ComputerPartVisitor computerPartVisitor) {
    computerPartVisitor.visit(this);
  }
}

