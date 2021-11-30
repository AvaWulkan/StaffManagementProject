package employees;

import static staffmanagementproject.HelpFunctions.setLenghtOfString;

public abstract class Employee {

    private String department;
    private int id;
    private String name;
    private int age;
    private String gender;
    private int salary;
    private int yearsOfEmployment;
    private final int BONUSBASE = 5000;
    private int bonus;
    
    public Employee(String name, int age, String gender, int salary, int yearsOfEmployment) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.yearsOfEmployment = yearsOfEmployment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBONUSBASE() {
        return BONUSBASE;
    }

    public int getYearsOfEmployment() {
        return yearsOfEmployment;
    }

    public void setYearsOfEmployment(int yearsOfEmployment) {
        this.yearsOfEmployment = yearsOfEmployment;
    }

    public abstract void countBonus(int bonusCoefficient);

    @Override
    public String toString() {
        return setLenghtOfString(String.valueOf(id), 5)
                + setLenghtOfString(name, 8)
                + setLenghtOfString(String.valueOf(age), 5)
                + setLenghtOfString(gender, 8)
                + setLenghtOfString(String.valueOf(salary), 9)
                + setLenghtOfString(String.valueOf(bonus), 9)
                + setLenghtOfString(String.valueOf(yearsOfEmployment), 20);
    }

}
