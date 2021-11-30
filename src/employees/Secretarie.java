package employees;

public class Secretarie extends Employee {

    public Secretarie(String name, int age, String gender, int salary, int yearsOfEmployment) {
        super(name, age, gender, salary, yearsOfEmployment);
        setDepartment("Secretarie");
        countBonus(yearsOfEmployment);
    }

    public void setYearsOfEmployment(int yearsOfEmployment) {
        super.setYearsOfEmployment(yearsOfEmployment);
        countBonus(yearsOfEmployment);
    }

    public void countBonus(int yearsOfEmployment) {
        int bonus = super.getBONUSBASE() + 500 * yearsOfEmployment;
        setBonus(bonus);
    }

    @Override
    public String toString() {
        return "Secretarie  " + super.toString();
    }

}
