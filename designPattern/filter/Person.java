package impl;

public class Person {
  private String name;
  private String gender;
  private String maritalStatus;

  public Person(String n, String g, String m) {
    name = n;
    gender = g;
    maritalStatus = m;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }
}

