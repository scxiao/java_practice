package impl;

import impl.Computer;
import impl.Mouse;
import impl.Keyboard;
import impl.Monitor;

public interface ComputerPartVisitor {
  public void visit(Computer computer);
  public void visit(Mouse mouse);
  public void visit(Keyboard keyboard);
  public void visit(Monitor monitor);
}

