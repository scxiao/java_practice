package impl;

import impl.Person;
import java.util.List;

public interface Criteria {
  public List<Person> meetCriteria(List<Person> persons);
}

