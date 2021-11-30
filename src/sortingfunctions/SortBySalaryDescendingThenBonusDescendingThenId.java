package sortingfunctions;

import java.util.Comparator;
import employees.Employee;

public class SortBySalaryDescendingThenBonusDescendingThenId implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary() == o2.getSalary()) {
            if (o1.getBonus() == o2.getBonus()) {
                return o1.getId() - o2.getId();
            }
            return o2.getBonus() - o1.getBonus();
        }
        return o2.getSalary() - o1.getSalary();
    }
}
