package impl;

import impl.Criteria;
import impl.Person;
import java.util.List;
import java.util.ArrayList;

public class CriteriaSingle implements Criteria {
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> singleList = new ArrayList<Person>();

    for (Person person : persons) {
      if (person.getMaritalStatus().equalsIgnoreCase("Single")) {
        singleList.add(person);
      }
    }

    return singleList;
  }
}

