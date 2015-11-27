package impl;

import impl.ComputerPartVisitor;

public interface ComputerPart {
  public void accept(ComputerPartVisitor computerPartVisitor);
}

