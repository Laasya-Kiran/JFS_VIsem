package com.skillnext1;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee JDBC Menu ---");
            System.out.println("1. Insert Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();

                    Employee emp = new Employee(id, name, email, sal);
                    dao.insertEmployee(emp);
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new Salary: ");
                    double newSal = sc.nextDouble();

                    dao.updateEmployee(uid, newSal);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();

                    dao.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
