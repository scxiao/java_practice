package impl;

public abstract class Student {
  String name;
  int age;

  Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public abstract int calcTuition();
  public abstract void printTuition();
  public abstract void setCredit(int c);

  public void printInfo() {
    System.out.println("Name: " + name + ", age: " + age);
    return;
  }
}

