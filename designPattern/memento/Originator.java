package impl;

public class Originator {
  private String state;

  public Originator() { }
  public Originator(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Memento saveStateToMemento() {
    return new Memento(state);
  }

  public void getStateFromMemento(Memento mem) {
    state = mem.getState();
  }
}

