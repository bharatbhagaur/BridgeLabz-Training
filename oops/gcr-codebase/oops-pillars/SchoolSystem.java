import java.util.*;

class Person {
    String name;
    int age;

    // constructor for Person class
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    String subject;

    // constructor for Teacher
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // method to display teacher role
    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    // constructor for Student
    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // method to display student role
    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    // constructor for Staff
    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // method to display staff role
    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Rahul", 35, "Maths");
        Student s = new Student("Aman", 16, "10th");
        Staff st = new Staff("Suresh", 45, "Administration");

        // displaying details
        System.out.println("Name: " + t.name + ", Age: " + t.age);
        t.displayRole();

        System.out.println();

        System.out.println("Name: " + s.name + ", Age: " + s.age);
        s.displayRole();

        System.out.println();

        System.out.println("Name: " + st.name + ", Age: " + st.age);
        st.displayRole();
    }
}