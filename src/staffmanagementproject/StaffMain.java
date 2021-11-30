package staffmanagementproject;

import employees.Secretarie;
import employees.Programmer;
import employees.Technician;
import static staffmanagementproject.HelpFunctions.readInt;

public class StaffMain {

    static boolean loop = true;

    public static void main(String[] args) {

//        int test = readInt();
//        System.out.println(test);
        loadDb();

        while (loop) {
            startProgram();
        }

    }

    private static void loadDb() {
        Programmer p1 = new Programmer("Anna", 27, "Female", 30000, 5, 23);
        Programmer p2 = new Programmer("Bengt", 21, "Male", 27000, 1, 4);
        Programmer p3 = new Programmer("Cissi", 34, "Female", 32000, 3, 12);
        Secretarie s1 = new Secretarie("David", 38, "Male", 234000, 9);
        Secretarie s5 = new Secretarie("David", 24, "Male", 29000, 2);
        Secretarie s4 = new Secretarie("David", 52, "Male", 43000, 12);
        Secretarie s2 = new Secretarie("Erika", 31, "Female", 27000, 2);
        Secretarie s3 = new Secretarie("Frank", 23, "Male", 22000, 1);
        Technician t1 = new Technician("Göran", 52, "Male", 35000, 12, 3);
        Technician t2 = new Technician("Hella", 32, "Female", 37000, 4, 1);
        Technician t3 = new Technician("Ivar", 28, "Male", 32000, 7, 2);

        StaffManagement.addEmployee(p1);
        StaffManagement.addEmployee(p2);
        StaffManagement.addEmployee(p3);
        StaffManagement.addEmployee(s1);
        StaffManagement.addEmployee(s2);
        StaffManagement.addEmployee(s3);
        StaffManagement.addEmployee(s4);
        StaffManagement.addEmployee(s5);
        StaffManagement.addEmployee(t1);
        StaffManagement.addEmployee(t2);
        StaffManagement.addEmployee(t3);

    }

    private static void startProgram() {
        Menus.mainMenu();
    }

}
