package impl;

import impl.Criteria;
import impl.Person;
import java.util.List;

public class OrCriteria implements Criteria {
  private Criteria criteria;
  private Criteria otherCriteria;

  public OrCriteria(Criteria c1, Criteria c2) {
    criteria = c1;
    otherCriteria = c2;
  }

  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> c1List = criteria.meetCriteria(persons);
    List<Person> c2List = otherCriteria.meetCriteria(persons);
    for (Person person : c2List) {
      if (!c1List.contains(person)) {
        c1List.add(person);
      }
    }

    return c1List;
  }
}

