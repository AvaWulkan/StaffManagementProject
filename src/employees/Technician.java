package employees;

import static staffmanagementproject.HelpFunctions.setLenghtOfString;

public class Technician extends Employee {

    int nrOfCrashedServers;

    public Technician(String name, int age, String gender, int salary, int yearsOfEmployment, int nrOfCrashedServers) {
        super(name, age, gender, salary, yearsOfEmployment);
        setDepartment("Technician");
        this.nrOfCrashedServers = nrOfCrashedServers;
        countBonus(nrOfCrashedServers);
    }

    public int getNrOfCrashedServers() {
        return nrOfCrashedServers;
    }

    public void setNrOfCrashedServers(int nrOfCrashedServers) {
        this.nrOfCrashedServers = nrOfCrashedServers;
        countBonus(nrOfCrashedServers);
    }

    public void countBonus(int nrOfCrashedServers) {
        int bonus = super.getBONUSBASE() - 500 * nrOfCrashedServers;
        if (bonus < 0) {
            bonus = 0;
        }
        setBonus(bonus);
    }

    @Override
    public String toString() {
        return "Technician  " + super.toString()
                + setLenghtOfString(String.valueOf(nrOfCrashedServers), 3);
    }

}
