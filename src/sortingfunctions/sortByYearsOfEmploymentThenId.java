
package sortingfunctions;

import java.util.Comparator;
import employees.Employee;


public class sortByYearsOfEmploymentThenId implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getYearsOfEmployment()==o2.getYearsOfEmployment()){
            return o1.getId()-o2.getId();
        }
        return o1.getYearsOfEmployment()-o2.getYearsOfEmployment();
    }


}
