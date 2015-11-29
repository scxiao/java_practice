package impl;

import impl.Filter;

public class DebugFilter implements Filter {
  public void execute(String request) {
    System.out.println("request log: " + request);
  }
}

