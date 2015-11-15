package impl;

import impl.Criteria;
import impl.Person;
import java.util.List;
import java.util.ArrayList;

public class CriteriaMale implements Criteria {
  public List<Person> meetCriteria(List<Person> persons) {
    List<Person> maleList = new ArrayList<Person>();

    for (Person person : persons) {
      if (person.getGender().equalsIgnoreCase("Male")) {
        maleList.add(person);
      }
    }

    return maleList;
  }
}

