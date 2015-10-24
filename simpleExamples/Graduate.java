package impl;
import impl.Student;

public class Graduate extends Student {
  int credits;
  int tuition;

  public Graduate(String name, int age) {
    super(name, age);
  }

  public void setCredit(int c) {
    credits = c;
  }

  public int calcTuition() {
    tuition = 6 * credits;
    return tuition;
  }

  public void printTuition() {
    System.out.println("Tuition = " + tuition);
  }
}
