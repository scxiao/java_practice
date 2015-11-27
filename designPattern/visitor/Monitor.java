package impl;

import impl.ComputerPart;

public class Monitor implements ComputerPart {
  public void accept(ComputerPartVisitor computerPartVisitor) {
    computerPartVisitor.visit(this);
  }
}

