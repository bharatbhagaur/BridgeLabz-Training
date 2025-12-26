import java.util.*;

class Course {
    String courseName;
    ArrayList<Student> students; // association: course has students

    // constructor to initialize course
    Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    // add student to course
    void addStudent(Student s) {
        students.add(s);
    }

    // display students enrolled in this course
    void displayStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println("Student: " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses; // association: student has courses

    // constructor to initialize student
    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    // enroll student in a course
    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this); // maintain two-way association
    }

    // display courses enrolled by student
    void displayCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("Course: " + c.courseName);
        }
    }
}

class School {
    String schoolName;
    ArrayList<Student> students; // aggregation: school has students

    // constructor to initialize school
    School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    // add student to school
    void addStudent(Student s) {
        students.add(s);
    }

    // display all students in school
    void displayStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            System.out.println("Student: " + s.name);
        }
    }
}

public class SchoolAndStudent {
    public static void main(String[] args) {
        // creating school
        School school = new School("Green Valley School");

        // creating students
        Student s1 = new Student("Amit");
        Student s2 = new Student("Neha");

        // creating courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");

        // aggregation: adding students to school
        school.addStudent(s1);
        school.addStudent(s2);

        // association: students enrolling in courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);

        System.out.println();

        // student views enrolled courses
        s1.displayCourses();
        System.out.println();
        s2.displayCourses();

        System.out.println();

        // course views enrolled students
        c1.displayStudents();
        System.out.println();
        c2.displayStudents();
    }
}