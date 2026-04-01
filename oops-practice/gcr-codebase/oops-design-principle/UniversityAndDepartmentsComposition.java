import java.util.*;

class Faculty {
    String name;

    // constructor to initialize faculty
    Faculty(String name) {
        this.name = name;
    }

    void displayFaculty() {
        System.out.println("Faculty Name: " + name);
    }
}

class Department {
    String deptName;

    // constructor to initialize department
    Department(String deptName) {
        this.deptName = deptName;
    }

    void displayDepartment() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    String universityName;
    ArrayList<Department> departments; // composition: university owns departments
    ArrayList<Faculty> faculties; // aggregation: faculty can exist independently

    // constructor to initialize university
    University(String universityName) {
        this.universityName = universityName;
        departments = new ArrayList<>();
        faculties = new ArrayList<>();
    }

    // add department to university
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // add faculty to university
    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    // display university details
    void displayUniversityDetails() {
        System.out.println("University: " + universityName);

        System.out.println("Departments:");
        for (Department d : departments) {
            d.displayDepartment();
        }

        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.displayFaculty();
        }
    }

    // simulate deletion of university
    void deleteUniversity() {
        departments.clear(); // departments are destroyed with university
        System.out.println("University deleted. All departments removed.");
    }
}

public class UniversityAndDepartmentsComposition {
    public static void main(String[] args) {
        // faculty objects can exist independently
        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Mehta");

        // creating university
        University uni = new University("Global University");

        // composition: departments belong to university
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        // aggregation: faculty added to university
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.displayUniversityDetails();
        System.out.println();

        // deleting university
        uni.deleteUniversity();
        System.out.println();

        // faculty still exists even after university deletion
        f1.displayFaculty();
        f2.displayFaculty();
    }
}