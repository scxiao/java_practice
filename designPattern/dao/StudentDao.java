package impl;

import java.util.List;
import impl.Student;

public interface StudentDao {
  public List<Student> getAllStudents();
  public Student getStudent(int rollNo);
  public void updateStudent(Student student);
  public void deleteStudent(Student student);
}

