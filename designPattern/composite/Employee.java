package impl;

import java.util.List;
import java.util.ArrayList;

public class Employee {
  private String name;
  private String dept;
  private int salary;

  private List<Employee> subordinate;

  public Employee(String name, String dept, int s) {
    this.name = name;
    this.dept = dept;
    this.salary = s;

    subordinate = new ArrayList<Employee>();
  }

  public void add(Employee e) {
    subordinate.add(e);
  }

  public void remove(Employee e) {
    subordinate.remove(e);
  }

  public List<Employee> getSubordinates() {
    return subordinate;
  }

  public String toString() {
    return ("Employee: [name: " + name + ", dept: " + dept + ", salary: " + salary + " ]");
  }
}

