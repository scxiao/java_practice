import impl.Student;
import impl.Graduate;
import impl.Undergraduate;

public class TestStudent {
  public static void print(Student s) {
    s.calcTuition();
    s.printInfo();
    s.printTuition();
  }

  public static void main(String[] args) {
    Student u = new Undergraduate("Tom", 18);
    u.setCredit(4);
    print(u);

    u = new Graduate("Jeremy", 24);
    u.setCredit(4);
    print(u);
  }
}

