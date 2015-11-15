import impl.Employee;

public class CompositePatternDemo {
  public static void main(String[] args) {
    Employee ceo = new Employee("John", "CEO", 20000);

    Employee headSales = new Employee("Robert", "Head sales", 20000);

    Employee headMarketing = new Employee("Michael", "Head marketing", 20000);

    Employee clerk1 = new Employee("Laura", "Marketing", 10000);
    Employee clerk2 = new Employee("Bob", "Marketing", 10000);

    Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
    Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

    ceo.add(headSales);
    ceo.add(headMarketing);

    headSales.add(salesExecutive1);
    headSales.add(salesExecutive2);

    headMarketing.add(clerk1);
    headMarketing.add(clerk2);

    System.out.println(ceo);

    for (Employee e : ceo.getSubordinates()) {
      System.out.format("\t");
      System.out.println(e);

      for (Employee e1 : e.getSubordinates()) {
        System.out.format("\t\t");
        System.out.println(e1);
      }
      System.out.println();
    }
  }
}

