package collectors;

import java.util.*;
import java.util.stream.Collectors;
class Student {
    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

public class StudentGrouping {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Amit", "A"),
            new Student("Neha", "B"),
            new Student("Ravi", "A"),
            new Student("Pooja", "C"),
            new Student("Karan", "B")
        );

        Map<String, List<String>> result =
            students.stream()
                    .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(Student::getName,
                                           Collectors.toList())
                    ));

        result.forEach((grade, names) ->
            System.out.println("Grade " + grade + " → " + names)
        );
    }
}
