package impl;

import impl.Criteria;
import impl.Person;
import java.util.List;

public class AndCriteria implements Criteria {
  private Criteria criteria;
  private Criteria otherCriteria;

  public AndCriteria(Criteria c1, Criteria c2) {
    criteria = c1;
    otherCriteria = c2;
  }

  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> c1List = criteria.meetCriteria(persons);
    return otherCriteria.meetCriteria(c1List);
  }
}

