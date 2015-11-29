import impl.StudentBO;
import impl.StudentVO;

public class TransferObjectPatternDemo {
  public static void main(String[] args) {
    StudentBO studentBO = new StudentBO();

    // print all students
    for (StudentVO student : studentBO.getAllStudents()) {
      System.out.println("Student: [RollNo : " + student.getRollNo() +
          ", Name : " + student.getName() + " ]");
    }

    // Update student
    StudentVO student = studentBO.getAllStudents().get(0);
    student.setName("Machael");
    studentBO.updateStudent(student);

    for (StudentVO student1 : studentBO.getAllStudents()) {
      System.out.println("Student: [RollNo : " + student1.getRollNo() +
          ", Name : " + student1.getName() + " ]");
    }
  }
}

