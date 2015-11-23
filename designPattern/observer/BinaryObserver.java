package impl;
import impl.Observer;
import impl.Subject;

public class BinaryObserver extends Observer {
  private Subject subject;
  public BinaryObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  public void update() {
    System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
  }
}

