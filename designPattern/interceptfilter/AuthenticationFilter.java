package impl;

import impl.Filter;

public class AuthenticationFilter implements Filter {
  public void execute(String request) {
    System.out.println("Authenticating request: " + request);
  }
}

