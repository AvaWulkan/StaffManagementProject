package staffmanagementproject;

import java.util.Scanner;
import static staffmanagementproject.HelpFunctions.readInt;
import static staffmanagementproject.StaffManagement.*;

public class Menus {

    static Scanner sc = new Scanner(System.in);
    static boolean loop;

    public static void mainMenu() {
        System.out.println("\nWhat doo you want too do?");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Update employee");
        System.out.println("4. Print employee");
        System.out.println("5. See employee statistc");
        System.out.println("0. Exit program");

        int choice = readInt();

        switch (choice) {
            case 1:
                loop = true;
                do {
                    StaffManagement.createEmployee();
                    System.out.println("\nDo you want to add another employee? (Y/N)");
                    String yesNo = sc.nextLine();
                    if (yesNo.equalsIgnoreCase("N")) {
                        loop = false;
                    }
                } while (loop);
                break;
            case 2:

                loop = true;
                do {
                    StaffManagement.removeEmployee();
                    System.out.println("\nDo you want to remove another employee? (Y/N)");
                    String yesNo = sc.nextLine();
                    if (yesNo.equalsIgnoreCase("N")) {
                        loop = false;
                    }
                } while (loop);
                break;
            case 3:

                loop = true;
                do {
                    StaffManagement.updateEmployee();
                    System.out.println("\nDo you want to update another employee? (Y/N)");
                    String yesNo = sc.nextLine();
                    if (yesNo.equalsIgnoreCase("N")) {
                        loop = false;
                    }
                } while (loop);

                break;
            case 4:
                printMenu();
                break;
            case 5:
                statisticMenu();
                break;
            case 0:
                System.exit(0);
            default:
                break;
        }
    }

    private static void statisticMenu() {
        boolean statisticLoop=true;
        while (statisticLoop) {
            System.out.println("\nWhat kind of statistics do you want to see?");
            System.out.println("1. Age");
            System.out.println("2. Gender");
            System.out.println("3. Salary");
            System.out.println("4. Bonus");
            System.out.println("0. Non, go back to main menu.");
            int choice = readInt();
            switch (choice) {
                case 1:
                    StaffManagement.ageStatistic();
                    break;
                case 2:
                    StaffManagement.genderStatistic();
                    break;
                case 3:
                    StaffManagement.salaryStatistic();
                    break;
                case 4:
                    StaffManagement.bonusStatistic();
                    break;
                case 0:
                    statisticLoop=false;
                default:
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nWhat do you want to print?");
        System.out.println("1. All employees");
        System.out.println("2. All secretaries");
        System.out.println("3. All technicians");
        System.out.println("4. All programmers");
        System.out.println("5. Print by id");
        System.out.println("0. Non, go back to main menu.");
        int choice = readInt();
        if (choice >= 1 && choice <= 4) {
            sortMenu();
        }
        switch (choice) {
            case 1:
                StaffManagement.printAllEmployees();
                break;
            case 2:
                StaffManagement.printAllSecretaries();
                break;
            case 3:
                StaffManagement.printAllTechnincians();
                break;
            case 4:
                StaffManagement.printAllProgrammers();
                break;
            case 5:
                StaffManagement.printById();
                break;
            case 0:
                mainMenu();
            default:
                break;
        }
    }

    private static void sortMenu() {
        System.out.println("\nHow do you want to sort the employees?");
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Gender");
        System.out.println("4. Salary");
        System.out.println("5. Bonus");
        System.out.println("6. Years of Employment");
        System.out.println("0. I changed my mind, go back to main menu.");
        int choice = readInt();
        switch (choice) {
            case 1:
                employees.sort(sortById);
                break;
            case 2:
                employees.sort(sortByName);
                break;
            case 3:
                employees.sort(sortByGender);
                break;
            case 4:
                employees.sort(sortBySalary);
                break;
            case 5:
                employees.sort(sortByBonus);
                break;
            case 6:
                employees.sort(sortByYearsOfEmployment);
                break;
            case 0:
                mainMenu();
                break;
            default:
                break;
        }

    }
}
