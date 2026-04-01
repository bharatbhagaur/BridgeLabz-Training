class Learner {

    public int id;              // public: accessible everywhere
    protected String fullName;  // protected: accessible in child class
    private double gradePoint;  // private: accessible only inside this class

    // constructor
    Learner(int id, String fullName, double gradePoint) {
        this.id = id;
        this.fullName = fullName;
        this.gradePoint = gradePoint;
    }

    // getter for private variable
    public double fetchGradePoint() {
        return gradePoint;
    }

    // setter for private variable
    public void updateGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }
}

// child class to demonstrate protected access
class MastersLearner extends Learner {

    MastersLearner(int id, String fullName, double gradePoint) {
        super(id, fullName, gradePoint);
    }

    void showStudentData() {
        System.out.println("Student ID: " + id);            // public access
        System.out.println("Student Name: " + fullName);    // protected access
        System.out.println("Grade Point: " + fetchGradePoint()); // private via method
    }
}

public class CollegeSystem {
    public static void main(String[] args) {

        MastersLearner student = new MastersLearner(101, "Amit", 8.5);

        student.showStudentData();

        student.updateGradePoint(9.0);  // modifying private data safely
        System.out.println("Revised Grade Point: " + student.fetchGradePoint());
    }
}
