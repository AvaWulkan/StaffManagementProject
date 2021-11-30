
package sortingfunctions;

import java.util.Comparator;
import employees.Employee;


public class SortByBonusThenSalaryThenId implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getBonus() == o2.getBonus()) {
            if (o1.getSalary() == o2.getSalary()) {
                return o1.getId() - o2.getId();
            }
            return o1.getSalary() - o2.getSalary();
        }
        return o1.getBonus() - o2.getBonus();
    }

    

}
