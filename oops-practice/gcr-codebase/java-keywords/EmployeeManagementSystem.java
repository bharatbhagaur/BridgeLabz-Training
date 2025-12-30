import java.util.*;

class Employee {
    // static variable shared by all employees
    static String companyName = "Tech Solutions";
    static int totalEmployees = 0;

    String name;
    final int id; // final: cannot be changed once assigned
    String designation;

    // constructor using this keyword
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // static method to display total employees
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // instance method to display employee details
    void displayDetails() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Designation: " + designation);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Amit", 101, "Software Engineer");
        Employee e2 = new Employee("Neha", 102, "QA Engineer");

        // instanceof check before displaying details
        if (e1 instanceof Employee) {
            e1.displayDetails();
        }

        System.out.println();

        if (e2 instanceof Employee) {
            e2.displayDetails();
        }

        System.out.println();
        Employee.displayTotalEmployees(); // static method call
    }
}
