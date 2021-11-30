
package sortingfunctions;

import java.util.Comparator;
import employees.Employee;


public class SortByGenderThenId implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getGender().equalsIgnoreCase(o2.getGender())){
                return o1.getId()-o2.getId();
            }
        return o1.getGender().compareToIgnoreCase(o2.getGender());
    }


}
