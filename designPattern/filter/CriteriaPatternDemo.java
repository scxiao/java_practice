import impl.Person;
import impl.Criteria;
import impl.CriteriaMale;
import impl.CriteriaFemale;
import impl.CriteriaSingle;
import impl.AndCriteria;
import impl.OrCriteria;
import java.util.List;
import java.util.ArrayList;

public class CriteriaPatternDemo {
  public static void main(String[] args) {
    List<Person> list = new ArrayList<Person>();

    list.add(new Person("Robert", "Male", "Single"));
    list.add(new Person("John",   "Male", "Married"));
    list.add(new Person("Laura",  "Female", "Married"));
    list.add(new Person("Diana",  "Female", "Single"));
    list.add(new Person("Mike",   "Male", "Single"));
    list.add(new Person("Bobby",  "Male", "Single"));
    list.add(new Person("Henry",  "Male", "Single"));
    list.add(new Person("Mary",   "Female", "Married"));

    Criteria male = new CriteriaMale();
    Criteria female = new CriteriaFemale();
    Criteria single = new CriteriaSingle();
    Criteria singleMale = new AndCriteria(single, male);
    Criteria singleOrFemale = new OrCriteria(single, female);

    System.out.println("Males:");
    printPersons(male.meetCriteria(list));

    System.out.println("\nFemale:");
    printPersons(female.meetCriteria(list));

    System.out.println("\nSingle males:");
    printPersons(singleMale.meetCriteria(list));

    System.out.println("\nSingle or female:");
    printPersons(singleOrFemale.meetCriteria(list));

    return;
  }

  static void printPersons(List<Person> list) {
    for (Person p : list) {
      System.out.println("Name: " + p.getName() +
          ",\t gender: " + p.getGender() +
          ",\t Marital status: " + p.getMaritalStatus());
    }
  }
}

