package collectors;

import java.util.*;
import java.util.stream.Collectors;
class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryAnalysis {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Amit", "IT", 60000),
            new Employee("Neha", "HR", 45000),
            new Employee("Ravi", "IT", 75000),
            new Employee("Pooja", "Finance", 50000),
            new Employee("Karan", "HR", 55000)
        );

        Map<String, Double> avgSalaryByDept =
            employees.stream()
                     .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(Employee::getSalary)
                     ));

        avgSalaryByDept.forEach((dept, avgSalary) ->
            System.out.println(dept + " → Average Salary: ₹" + avgSalary)
        );
    }
}

