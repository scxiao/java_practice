package impl;

import impl.Student;

public class Undergraduate extends Student {
  int credits;
  int tuition;

  public Undergraduate(String name, int age) {
    super(name, age);
  }

  public void setCredit(int c) {
    credits = c;
  }

  public int calcTuition() {
    tuition = 3 * credits;
    return tuition;
  }

  public void printTuition() {
    System.out.println("Tuition = " + tuition);
  }
}
