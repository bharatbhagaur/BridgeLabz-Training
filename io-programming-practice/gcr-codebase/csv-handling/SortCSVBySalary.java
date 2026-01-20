package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
    String id;
    String name;
    String department;
    double salary;

    // Constructor
    Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortCSVBySalary {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\employees.csv";
        String line;

        ArrayList<Employee> employees = new ArrayList<>();

        try {
            // Read CSV file
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // Skip header
            br.readLine();

            // Read each row
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                // Add employee object to list
                employees.add(new Employee(id, name, department, salary));
            }

            br.close();

            // Sort list by salary (Descending)
            Collections.sort(employees, new Comparator<Employee>() {
                public int compare(Employee e1, Employee e2) {
                    return Double.compare(e2.salary, e1.salary); // Descending
                }
            });

            System.out.println("🏆 Top 5 Highest Paid Employees:\n");

            // Print top 5 employees
            for (int i = 0; i < 5 && i < employees.size(); i++) {
                Employee e = employees.get(i);
                System.out.println(
                        (i + 1) + ". " +
                        e.name + " | " +
                        e.department + " | Salary: " + e.salary
                );
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

