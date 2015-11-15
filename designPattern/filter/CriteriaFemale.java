package impl;

import impl.Criteria;
import impl.Person;
import java.util.List;
import java.util.ArrayList;

public class CriteriaFemale implements Criteria {
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> femaleList = new ArrayList<Person>();

    for (Person person : persons) {
      if (person.getGender().equalsIgnoreCase("Female")) {
        femaleList.add(person);
      }
    }

    return femaleList;
  }
}

