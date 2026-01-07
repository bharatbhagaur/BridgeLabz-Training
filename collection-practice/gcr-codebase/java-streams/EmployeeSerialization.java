package javastream;

import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable {

    // recommended for Serializable classes
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    // constructor
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // method to display employee details
    void display() {
        System.out.println(id + " | " + name + " | " + department + " | " + salary);
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> empList = new ArrayList<>();

        try {
            // ----------- TAKING EMPLOYEE INPUT -----------
            System.out.print("Enter number of employees: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEmployee " + i);

                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Salary: ");
                double salary = Double.parseDouble(sc.nextLine());

                empList.add(new Employee(id, name, dept, salary));
            }

            // ----------- SERIALIZATION (SAVE TO FILE) -----------
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("employees.dat"));

            oos.writeObject(empList);   // writing whole list
            oos.close();

            System.out.println("\nEmployees saved successfully!\n");

            // ----------- DESERIALIZATION (READ FROM FILE) -----------
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("employees.dat"));

            List<Employee> savedList = (List<Employee>) ois.readObject();
            ois.close();

            // ----------- DISPLAY EMPLOYEES -----------
            System.out.println("Employees from file:");
            System.out.println("ID | Name | Department | Salary");

            for (Employee e : savedList) {
                e.display();
            }

        }
        catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found while reading file.");
        }
    }
}
