package sortingfunctions;

import java.util.Comparator;
import employees.Employee;

public class SortByDepartmentThenId implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getDepartment().equalsIgnoreCase(o2.getDepartment())) {
            return o1.getId() - o2.getId();
        }
        return o1.getDepartment().compareToIgnoreCase(o2.getDepartment());
    }

}
