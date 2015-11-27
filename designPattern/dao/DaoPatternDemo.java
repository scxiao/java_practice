import impl.StudentDao;
import impl.StudentDaoImpl;
import impl.Student;

public class DaoPatternDemo {
  public static void main(String[] args) {
    StudentDao studentDao = new StudentDaoImpl();

    // print all students
    for (Student student : studentDao.getAllStudents()) {
      System.out.println("Student: [RollNo : " +
          student.getRollNo() + ", Name : " +
          student.getName() + " ]");
    }

    Student student = studentDao.getAllStudents().get(0);
    student.setName("Michael");
    studentDao.updateStudent(student);

    studentDao.getStudent(0);
    for (Student student1 : studentDao.getAllStudents()) {
      System.out.println("Student: [RollNo : " +
          student1.getRollNo() + ", Name : " +
          student1.getName() + " ]");
    }
  }
}

