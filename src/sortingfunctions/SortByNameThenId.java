
package sortingfunctions;

import java.util.Comparator;
import employees.Employee;


public class SortByNameThenId implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getName().equalsIgnoreCase(o2.getName())){
            return o1.getId()-o2.getId();
        }
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}
