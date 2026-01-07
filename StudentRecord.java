import java.util.Scanner;

public class StudentRecord {

    static Scanner sc = new Scanner(System.in);

    static int[] id = new int[50];
    static String[] name = new String[50];
    static int[] marks = new int[50];

    static int count = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        id[count] = sc.nextInt();

        System.out.print("Enter Name: ");
        name[count] = sc.next();

        System.out.print("Enter Marks: ");
        marks[count] = sc.nextInt();

        count++;
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (count == 0) {
            System.out.println("No records found");
            return;
        }

        System.out.println("\nID\tName\tMarks");
        for (int i = 0; i < count; i++) {
            System.out.println(id[i] + "\t" + name[i] + "\t" + marks[i]);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (id[i] == searchId) {
                System.out.println("Record Found:");
                System.out.println(id[i] + " " + name[i] + " " + marks[i]);
                return;
            }
        }
        System.out.println("Student not found");
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int updateId = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (id[i] == updateId) {
                System.out.print("Enter new name: ");
                name[i] = sc.next();

                System.out.print("Enter new marks: ");
                marks[i] = sc.nextInt();

                System.out.println("Record updated");
                return;
            }
        }
        System.out.println("Student not found");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int deleteId = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (id[i] == deleteId) {
                for (int j = i; j < count - 1; j++) {
                    id[j] = id[j + 1];
                    name[j] = name[j + 1];
                    marks[j] = marks[j + 1];
                }
                count--;
                System.out.println("Record deleted");
                return;
            }
        }
        System.out.println("Student not found");
    }
}
