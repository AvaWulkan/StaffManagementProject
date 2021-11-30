package staffmanagementproject;

import employees.Secretarie;
import employees.Programmer;
import employees.Technician;
import employees.Employee;
import sortingfunctions.sortByYearsOfEmploymentThenId;
import sortingfunctions.SortByBonusThenSalaryThenId;
import sortingfunctions.SortBySalaryDescendingThenBonusDescendingThenId;
import sortingfunctions.SortByDepartmentThenId;
import sortingfunctions.SortByNameThenId;
import sortingfunctions.SortByGenderThenId;
import static staffmanagementproject.HelpFunctions.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StaffManagement {

    static int idGenerator = 1;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();
    public static Comparator<Employee> sortById = Comparator.comparing(e -> e.getId());
    public static Comparator<Employee> sortByName = new SortByNameThenId();
    public static Comparator<Employee> sortBySalary = new SortBySalaryDescendingThenBonusDescendingThenId();
    public static Comparator<Employee> sortByBonus = new SortByBonusThenSalaryThenId();
    public static Comparator<Employee> sortByGender = new SortByGenderThenId();
    public static Comparator<Employee> sortByDepartment = new SortByDepartmentThenId();
    public static Comparator<Employee> sortByYearsOfEmployment = new sortByYearsOfEmploymentThenId();

    public static void createEmployee() {
        System.out.println("");

        int department = inputDepartment();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = readInt();

        System.out.println("Gender: ");
        String gender = inputGender();

        System.out.print("Salary: ");
        int salary = readInt();

        System.out.print("Years of Employment: ");
        int yearsOfEmployment = readInt();

        switch (department) {
            case 1:
                Secretarie s = new Secretarie(name, age, gender, salary, yearsOfEmployment);
                addEmployee(s);
                break;
            case 2:
                System.out.print("Numbers Of Crashed Servers: ");
                int nrOfCrashedServers = readInt();
                Technician t = new Technician(name, age, gender, salary, yearsOfEmployment, nrOfCrashedServers);
                addEmployee(t);
                break;
            case 3:
                System.out.print("Numbers Of Build Programms: ");
                int nrOfBuildProgramms = readInt();
                Programmer p = new Programmer(name, age, gender, salary, yearsOfEmployment, nrOfBuildProgramms);
                addEmployee(p);
                break;
            default:
                break;
        }
    }

    public static void addEmployee(Employee e) {
        e.setId(idGenerator);
        employees.add(e);

        idGenerator++;
    }

    public static void removeEmployee() {
        printAllEmployees();
        System.out.println("\nWich employee do you want to delete?");
        System.out.print("Id: ");
        int id = readInt();

        if (findEmployeeById(id) != null) {
            employees.removeIf(employees -> employees.getId() == id);
            System.out.println("Employee successfully removed.");
        }
    }

    public static void updateEmployee() {
        printAllEmployees();
        System.out.println("\nId: ");
        int id = readInt();

        Employee e = findEmployeeById(id);
        if (e != null) {
            listEmployeeAttributes(e);
            int choice = readInt();
            switch (choice) {
                case 1:
                    System.out.print("New name: ");
                    e.setName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("New age: ");
                    e.setAge(readInt());
                    break;
                case 3:
                    System.out.println("New gender: ");
                    e.setGender(inputGender());
                    break;
                case 4:
                    System.out.print("New Salary: ");
                    e.setSalary(readInt());
                    break;
                case 5:
                    System.out.print("New numbers of years of employment: ");
                    e.setYearsOfEmployment(readInt());
                    break;
                case 6:
                    if (e instanceof Technician) {
                        Technician tec = (Technician) e;
                        System.out.print("New number of crushed servers: ");
                        tec.setNrOfCrashedServers(readInt());
                    } else if (e instanceof Programmer) {
                        Programmer pro = (Programmer) e;
                        System.out.print("New number of built programms: ");
                        pro.setNrOfBuildProgramms(readInt());
                    }
                    break;
                default:
                    break;
            }
            printDividerLine();
            System.out.println(e);
            printDividerLine();
        }
    }

    public static void printAllEmployees() {
        printColumnName();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        printDividerLine();
    }

    static void printAllSecretaries() {
        printColumnName();
        for (Employee employee : employees) {
            if (employee instanceof Secretarie) {
                System.out.println(employee);
            }
        }
        printDividerLine();
    }

    static void printAllTechnincians() {
        printColumnName();
        for (Employee employee : employees) {
            if (employee instanceof Technician) {
                System.out.println(employee);
            }
        }
        printDividerLine();
    }

    static void printAllProgrammers() {
        printColumnName();
        for (Employee employee : employees) {
            if (employee instanceof Programmer) {
                System.out.println(employee);
            }
        }
        printDividerLine();
    }

    public static void printById() {

        System.out.print("\nEnter id: ");
        int id = readInt();
        Employee e = findEmployeeById(id);
        printColumnName();
        if (e != null) {
            System.out.println(e);
        }
        printDividerLine();
    }

    static void ageStatistic() {
        System.out.println("\nDo you want to see statistics based on ");
        System.out.println("1. All employees");
        System.out.println("2. Gender");
        System.out.println("3. Department");

        int choice = readInt();
        double sumAge = 0;
        double averageAge;
        int nrOfEmployees = 0;
        switch (choice) {
            case 1:
                for (Employee employee : employees) {
                    sumAge += employee.getAge();
                    nrOfEmployees++;
                }
                printDividerLine();
                averageAge = sumAge / nrOfEmployees;
                System.out.println("Average age of all employees are: " + averageAge + " years");
                printDividerLine();
                break;
            case 2:
                System.out.println("\nWich gender do you want to see statistic about?");
                System.out.println("1. Female");
                System.out.println("2. Male");
                int choice2 = readInt();
                switch (choice2) {
                    case 1:
                        for (Employee employee : employees) {
                            if (employee.getGender().equalsIgnoreCase("Female")) {
                                sumAge += employee.getAge();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageAge = sumAge / nrOfEmployees;
                        System.out.println("Average age of females are: " + averageAge + " years");
                        printDividerLine();
                        break;
                    case 2:
                        for (Employee employee : employees) {
                            if (employee.getGender().equalsIgnoreCase("Male")) {
                                sumAge += employee.getAge();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageAge = sumAge / nrOfEmployees;
                        System.out.println("Average age of males are: " + averageAge + " years");
                        printDividerLine();
                        break;
                    default:
                }
                break;
            case 3:
                System.out.println("\nWich department do you want to see statistic about?");
                System.out.println("1. Secretaries");
                System.out.println("2. Technicians");
                System.out.println("3. Programmers");
                int choice3 = readInt();
                switch (choice3) {
                    case 1:
                        for (Employee employee : employees) {
                            if (employee instanceof Secretarie) {
                                sumAge += employee.getAge();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageAge = sumAge / nrOfEmployees;
                        System.out.println("Average age for secretaries are: " + averageAge + " years");
                        printDividerLine();
                        break;
                    case 2:
                        for (Employee employee : employees) {
                            if (employee instanceof Technician) {
                                sumAge += employee.getAge();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageAge = sumAge / nrOfEmployees;
                        System.out.println("Average age for technicians are: " + averageAge + " years");
                        printDividerLine();
                        break;
                    case 3:
                        for (Employee employee : employees) {
                            if (employee instanceof Programmer) {
                                sumAge += employee.getAge();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageAge = sumAge / nrOfEmployees;
                        System.out.println("Average age for programmers are: " + averageAge + " years");
                        printDividerLine();
                        break;
                    default:
                }
                break;
            default:
                break;
        }

    }

    static void genderStatistic() {
        System.out.println("\nDo you want to see statistics based on ");
        System.out.println("1. All employees");
        System.out.println("2. Department");

        int choice = readInt();
        int nrOfFemale = 0;
        int nrOfMale = 0;
        double genderDistribution;
        double nrOfEmployees = 0;
        switch (choice) {
            case 1:

                for (Employee employee : employees) {
                    if (employee.getGender().equalsIgnoreCase("Female")) {
                        nrOfFemale++;
                        nrOfEmployees++;
                    } else if (employee.getGender().equalsIgnoreCase("Male")) {
                        nrOfMale++;
                        nrOfEmployees++;
                    } else {
                        nrOfEmployees++;
                    }
                }
                printDividerLine();
                genderDistribution = nrOfFemale / nrOfEmployees * 100;
                System.out.format("%.2f percents of the employees are female\n", genderDistribution);
                genderDistribution = nrOfMale / nrOfEmployees * 100;
                System.out.format("%.2f percents of the employees are male\n", genderDistribution);
                printDividerLine();
                break;
            case 2:
                System.out.println("Wich department do you want to see statistic about?");
                System.out.println("1. Secretaries");
                System.out.println("2. Technicians");
                System.out.println("3. Programmers");
                int choice3 = readInt();
                switch (choice3) {
                    case 1:
                        for (Employee employee : employees) {
                            if (employee instanceof Secretarie) {
                                if (employee.getGender().equalsIgnoreCase("Female")) {
                                    nrOfFemale++;
                                    nrOfEmployees++;
                                } else if (employee.getGender().equalsIgnoreCase("Male")) {
                                    nrOfMale++;
                                    nrOfEmployees++;
                                } else {
                                    nrOfEmployees++;
                                }
                            }
                        }
                        printDividerLine();
                        genderDistribution = nrOfFemale / nrOfEmployees * 100;
                        System.out.format("%.2f percents of the secreteries are female\n", genderDistribution);
                        genderDistribution = nrOfMale / nrOfEmployees * 100;
                        System.out.format("%.2f percents of the secretaries are male\n", genderDistribution);
                        printDividerLine();
                        break;
                    case 2:
                        for (Employee employee : employees) {
                            if (employee instanceof Technician) {
                                if (employee.getGender().equalsIgnoreCase("Female")) {
                                    nrOfFemale++;
                                    nrOfEmployees++;
                                } else if (employee.getGender().equalsIgnoreCase("Male")) {
                                    nrOfMale++;
                                    nrOfEmployees++;
                                } else {
                                    nrOfEmployees++;
                                }
                            }
                        }
                        printDividerLine();
                        genderDistribution = nrOfFemale / nrOfEmployees * 100;
                        System.out.format("%.2f percents of the technincians are female\n", genderDistribution);
                        genderDistribution = nrOfMale / nrOfEmployees * 100;
                        System.out.format("%.2f percents of the technincians are male\n", genderDistribution);
                        printDividerLine();
                        break;
                    case 3:
                        for (Employee employee : employees) {
                            if (employee instanceof Programmer) {
                                if (employee.getGender().equalsIgnoreCase("Female")) {
                                    nrOfFemale++;
                                    nrOfEmployees++;
                                } else if (employee.getGender().equalsIgnoreCase("Male")) {
                                    nrOfMale++;
                                    nrOfEmployees++;
                                } else {
                                    nrOfEmployees++;
                                }
                            }
                        }
                        printDividerLine();
                        genderDistribution = nrOfFemale / nrOfEmployees * 100;
                        System.out.format("%.2f percents of the programmers are female\n", genderDistribution);
                        genderDistribution = nrOfMale / nrOfEmployees * 100;
                        System.out.format("%.2f percents of the programmers are male\n", genderDistribution);
                        printDividerLine();
                        break;
                    default:
                }
                break;
            default:
                break;
        }
    }

    static void salaryStatistic() {
        System.out.println("\nDo you want to see statistics based on ");
        System.out.println("1. All employees");
        System.out.println("2. Gender");
        System.out.println("3. Department");

        int choice = readInt();
        double sumSalary = 0;
        double averageSalary;
        int nrOfEmployees = 0;
        switch (choice) {
            case 1:
                for (Employee employee : employees) {
                    sumSalary += employee.getSalary();
                    nrOfEmployees++;
                }
                printDividerLine();
                averageSalary = sumSalary / nrOfEmployees;
                System.out.println("SALARY STATISTICS FOR ALL EMPLOYEES");
                printDividerLine();
                System.out.println("Average salary: " + averageSalary);
                System.out.println("Lowest salary: " + findLowestSalary(employees));
                System.out.println("Highest salary: " + findHighestSalary(employees));
                printDividerLine();
                break;
            case 2:
                System.out.println("\nWich gender do you want to see statistic about?");
                System.out.println("1. Female");
                System.out.println("2. Male");
                int choice2 = readInt();
                switch (choice2) {
                    case 1:
                        for (Employee employee : employees) {
                            if (employee.getGender().equalsIgnoreCase("Female")) {
                                sumSalary += employee.getSalary();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageSalary = sumSalary / nrOfEmployees;
                        System.out.println("SALARY STATISTICS FOR ALL FEMALE EMPLOYEES");
                        printDividerLine();
                        System.out.println("Average salary: " + averageSalary);
                        System.out.println("Lowest salary: " + findLowestSalary(findAllFemales()));
                        System.out.println("Highest salary: " + findHighestSalary(findAllFemales()));
                        printDividerLine();
                        break;
                    case 2:
                        for (Employee employee : employees) {
                            if (employee.getGender().equalsIgnoreCase("Male")) {
                                sumSalary += employee.getSalary();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageSalary = sumSalary / nrOfEmployees;
                        System.out.println("SALARY STATISTICS FOR ALL MALE EMPLOYEES");
                        printDividerLine();
                        System.out.println("Average salary: " + averageSalary);
                        System.out.println("Lowest salary: " + findLowestSalary(findAllMales()));
                        System.out.println("Highest salary: " + findHighestSalary(findAllMales()));
                        printDividerLine();
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                System.out.println("\nWich department do you want to see statistic about?");
                System.out.println("1. Secretaries");
                System.out.println("2. Technicians");
                System.out.println("3. Programmers");
                int choice3 = readInt();
                switch (choice3) {
                    case 1:
                        for (Employee employee : employees) {
                            if (employee instanceof Secretarie) {
                                sumSalary += employee.getSalary();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageSalary = sumSalary / nrOfEmployees;
                        System.out.println("SALARY STATISTICS FOR ALL SECRETARIES");
                        printDividerLine();
                        System.out.println("Average salary: " + averageSalary);
                        System.out.println("Lowest salary: " + findLowestSalary(findAllSecretaries()));
                        System.out.println("Highest salary: " + findHighestSalary(findAllSecretaries()));
                        printDividerLine();
                        break;
                    case 2:
                        for (Employee employee : employees) {
                            if (employee instanceof Technician) {
                                sumSalary += employee.getSalary();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageSalary = sumSalary / nrOfEmployees;
                        System.out.println("SALARY STATISTICS FOR ALL TECHNICIANS");
                        printDividerLine();
                        System.out.println("Average salary: " + averageSalary);
                        System.out.println("Lowest salary: " + findLowestSalary(findAllTechnicians()));
                        System.out.println("Highest salary: " + findHighestSalary(findAllTechnicians()));
                        printDividerLine();
                        break;
                    case 3:
                        for (Employee employee : employees) {
                            if (employee instanceof Programmer) {
                                sumSalary += employee.getSalary();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageSalary = sumSalary / nrOfEmployees;
                        System.out.println("SALARY STATISTICS FOR ALL PROGRAMMERS");
                        printDividerLine();
                        System.out.println("Average salary: " + averageSalary);
                        System.out.println("Lowest salary: " + findLowestSalary(findAllProgrammers()));
                        System.out.println("Highest salary: " + findHighestSalary(findAllProgrammers()));
                        printDividerLine();
                        break;
                    default:
                }
                break;
            default:
                break;
        }

    }

    static void bonusStatistic() {

        System.out.println("\nDo you want to see statistics based on ");
        System.out.println("1. All employees");
        System.out.println("2. Department");

        int choice = readInt();
        double sumBonus = 0;
        double averageBonus;
        int nrOfEmployees = 0;
        switch (choice) {
            case 1:
                for (Employee employee : employees) {
                    sumBonus += employee.getBonus();
                    nrOfEmployees++;
                }
                printDividerLine();
                averageBonus = sumBonus / nrOfEmployees;
                System.out.println("BONUS STATISTICS FOR ALL EMPLOYEES");
                printDividerLine();
                System.out.println("Average bonus: " + averageBonus);
                System.out.println("Lowest bonus: " + findLowestBonus(employees));
                System.out.println("Highest bonus: " + findHighestBonus(employees));
                printDividerLine();
                break;
            case 2:
                System.out.println("\nWich department do you want to see statistic about?");
                System.out.println("1. Secretaries");
                System.out.println("2. Technicians");
                System.out.println("3. Programmers");
                int choice3 = readInt();
                switch (choice3) {
                    case 1:
                        for (Employee employee : employees) {
                            if (employee instanceof Secretarie) {
                                sumBonus += employee.getBonus();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageBonus = sumBonus / nrOfEmployees;
                        System.out.println("BONUS STATISTICS FOR ALL SECRETARIES");
                        printDividerLine();
                        System.out.println("Average bonus: " + averageBonus);
                        System.out.println("Lowest bonus: " + findLowestBonus(findAllSecretaries()));
                        System.out.println("Highest bonus: " + findHighestBonus(findAllSecretaries()));
                        printDividerLine();
                        break;
                    case 2:
                        for (Employee employee : employees) {
                            if (employee instanceof Technician) {
                                sumBonus += employee.getBonus();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageBonus = sumBonus / nrOfEmployees;
                        System.out.println("BONUS STATISTICS FOR ALL TECHNICIANS");
                        printDividerLine();
                        System.out.println("Average bonus: " + averageBonus);
                        System.out.println("Lowest bonus: " + findLowestBonus(findAllTechnicians()));
                        System.out.println("Highest bonus: " + findHighestBonus(findAllTechnicians()));
                        printDividerLine();
                        break;
                    case 3:
                        for (Employee employee : employees) {
                            if (employee instanceof Programmer) {
                                sumBonus += employee.getBonus();
                                nrOfEmployees++;
                            }
                        }
                        printDividerLine();
                        averageBonus = sumBonus / nrOfEmployees;
                        System.out.println("BONUS STATISTICS FOR ALL PROGRAMMERS");
                        printDividerLine();
                        System.out.println("Average bonus: " + averageBonus);
                        System.out.println("Lowest bonus: " + findLowestBonus(findAllProgrammers()));
                        System.out.println("Highest bonus: " + findHighestBonus(findAllProgrammers()));
                        printDividerLine();
                        break;
                    default:
                }
                break;
            default:
                break;
        }
    }
}
