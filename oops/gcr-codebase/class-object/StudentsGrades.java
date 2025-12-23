public class StudentsGrades {

    String name;            // student name
    String rollNumber;      // student roll number
    double[] marks;         // array to store marks

    // Constructor to initialize values
    StudentsGrades(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on average marks
    public String calculateGrade() {

        double averageMarks = calculateAverageMarks(); // calculate average

        if (averageMarks >= 80 && averageMarks <= 100) {
            return "Grade A";
        } else if (averageMarks >= 60) {
            return "Grade B";
        } else if (averageMarks >= 50) {
            return "Grade C";
        } else if (averageMarks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    // Method to display student details
    public void displayStudent() {

        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark" + (i + 1) + ": " + marks[i]);
        }

        System.out.println(calculateGrade());
        System.out.println(); // spacing
    }

    // Method to calculate average marks
    public double calculateAverageMarks() {

        double sum = 0;

        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }

        return sum / marks.length; // dynamic calculation
    }

    public static void main(String[] args) {

        // Marks for students
        double[] marks1 = {80, 70, 75};
        double[] marks2 = {60, 65, 50};

        // Creating student objects
        StudentsGrades student1 =
                new StudentsGrades("Thamarai", "ECE001", marks1);

        StudentsGrades student2 =
                new StudentsGrades("Kannan", "CSC002", marks2);

        // Display reports
        student1.displayStudent();
        student2.displayStudent();
    }
}
