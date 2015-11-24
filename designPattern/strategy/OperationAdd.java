package impl;

import impl.Strategy;

public class OperationAdd implements Strategy {
  public int doOperation(int n1, int n2) {
    return n1 + n2;
  }
}

