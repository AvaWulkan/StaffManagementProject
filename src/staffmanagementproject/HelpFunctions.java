package staffmanagementproject;

import employees.Secretarie;
import employees.Programmer;
import employees.Technician;
import employees.Employee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import static staffmanagementproject.StaffManagement.*;

public class HelpFunctions {

    public static int readInt() {
        boolean runAgain = true;
        int input = -1;
        while (runAgain) {
            try {
                input = sc.nextInt();
                sc.nextLine();
                runAgain = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Wrong input. Only numbers are allowed.");
                System.out.print("Try again: ");
            }
        }
        return input;
    }

    public static String setLenghtOfString(String s, int length) {
        int stringLength = s.length();
        for (int i = stringLength; i < length; i++) {
            s += " ";
        }
        return s;
    }

    public static void printColumnName() {
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
        System.out.println("DEPARTMENT  ID   NAME    AGE  GENDER  SALARY   BONUS   YEARS OF EMPLOYMENT  NR OF BUILD PROGRAMS/NR Of CRASHED SERVERS");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }

    public static void printDividerLine() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

    }

    public static ArrayList<Employee> findAllFemales() {
        ArrayList<Employee> females = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGender().equalsIgnoreCase("Female")) {
                females.add(employee);
            }
        }
        return females;
    }

    public static ArrayList<Employee> findAllMales() {
        ArrayList<Employee> males = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGender().equalsIgnoreCase("Male")) {
                males.add(employee);
            }
        }
        return males;
    }

    public static ArrayList<Employee> findAllSecretaries() {
        ArrayList<Employee> secretaries = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Secretarie) {
                secretaries.add(employee);
            }
        }
        return secretaries;
    }

    public static ArrayList<Employee> findAllTechnicians() {
        ArrayList<Employee> technicians = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Secretarie) {
                technicians.add(employee);
            }
        }
        return technicians;
    }

    public static ArrayList<Employee> findAllProgrammers() {
        ArrayList<Employee> programmers = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Secretarie) {
                programmers.add(employee);
            }
        }
        return programmers;
    }

    public static int findLowestSalary(ArrayList<Employee> employees) {
        int lowestSalary = employees.get(0).getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < lowestSalary) {
                lowestSalary = employee.getSalary();
            }
        }
        return lowestSalary;
    }

    public static int findHighestSalary(ArrayList<Employee> employees) {
        int highestSalary = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > highestSalary) {
                highestSalary = employee.getSalary();
            }
        }
        return highestSalary;
    }

    public static int findLowestBonus(ArrayList<Employee> employees) {
        int lowestBonus = employees.get(0).getBonus();
        for (Employee employee : employees) {
            if (employee.getBonus() < lowestBonus) {
                lowestBonus = employee.getBonus();
            }
        }
        return lowestBonus;
    }

    public static int findHighestBonus(ArrayList<Employee> employees) {
        int highestBonus = 0;
        for (Employee employee : employees) {
            if (employee.getBonus() > highestBonus) {
                highestBonus = employee.getBonus();
            }
        }
        return highestBonus;
    }

    public static Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        System.out.println("Employee with that id does not exist.");
        return null;
    }

    public static String inputGender() {

        System.out.println("1. Female");
        System.out.println("2. Male");
        int genderChoice = readInt();
        String gender = "Unknown";
        switch (genderChoice) {
            case 1:
                gender = "Female";
                break;
            case 2:
                gender = "Male";
                break;
            default:
                System.out.println("Wrong input, set to unknown.");
        }
        return gender;
    }

    public static int inputDepartment() {
        while (true) {
            System.out.println("In wich department do the employee work?");
            System.out.println("1. Secretarie");
            System.out.println("2. Technician");
            System.out.println("3. Programmer");
            int department = readInt();
            if (department == 1 || department == 2 || department == 3) {
                return department;
            }
            System.out.println("Wrong input");
        }
    }

    public static void listEmployeeAttributes(Employee e) {
        System.out.println("\n1. Name");
        System.out.println("2. Age");
        System.out.println("3. Gender");
        System.out.println("4. Salary");
        System.out.println("5. Years of employment");

        if (e instanceof Technician) {
            System.out.println("6. Numbers of crashed servers");
        } else if (e instanceof Programmer) {
            System.out.println("6. Numbers of built programms");
        }
    }
}
