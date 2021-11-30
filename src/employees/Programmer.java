package employees;

import static staffmanagementproject.HelpFunctions.setLenghtOfString;

public class Programmer extends Employee {

    int nrOfBuildProgramms;

    public Programmer(String name, int age, String gender, int salary, int yearsOfEmployment, int nrOfBuildProgramms) {
        super(name, age, gender, salary, yearsOfEmployment);
        setDepartment("Programmer");
        this.nrOfBuildProgramms = nrOfBuildProgramms;
        countBonus(nrOfBuildProgramms);
    }

    public int getNrOfBuildProgramms() {
        return nrOfBuildProgramms;
    }

    public void setNrOfBuildProgramms(int nrOfBuildProgramms) {
        this.nrOfBuildProgramms = nrOfBuildProgramms;
        countBonus(nrOfBuildProgramms);
    }

    public void countBonus(int nrOfBuildProgramms) {
        int bonus = super.getBONUSBASE() + 500 * nrOfBuildProgramms;
        setBonus(bonus);

    }

    @Override
    public String toString() {
        return "Programmer  " + super.toString()
                + setLenghtOfString(String.valueOf(nrOfBuildProgramms), 4);
    }

}
