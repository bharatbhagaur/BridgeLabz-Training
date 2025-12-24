import java.util.*; 

class Employee {
    String name;
    int id;
    double salary;

    // method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.print("Enter name: ");
        emp.name = sc.nextLine();

        System.out.print("Enter id: ");
        emp.id = sc.nextInt();

        System.out.print("Enter salary: ");
        emp.salary = sc.nextDouble();

        emp.displayDetails(); // method call

        sc.close();
    }
}