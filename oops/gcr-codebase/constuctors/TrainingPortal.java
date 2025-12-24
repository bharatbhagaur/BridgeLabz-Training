class TrainingProgram {

    // instance data members
    String programTitle;
    int timePeriod;        // duration in months
    double programCost;

    // static data member (shared by all objects)
    static String academyName = "ABC Institute";

    // parameterized constructor
    TrainingProgram(String programTitle, int timePeriod, double programCost) {
        this.programTitle = programTitle;
        this.timePeriod = timePeriod;
        this.programCost = programCost;
    }

    // instance method to show program information
    void showProgramInfo() {
        System.out.println("Academy : " + academyName);
        System.out.println("Program : " + programTitle);
        System.out.println("Duration : " + timePeriod + " months");
        System.out.println("Cost : " + programCost);
    }

    // static method to modify academy name
    static void changeAcademyName(String updatedName) {
        academyName = updatedName;
    }
}

public class TrainingPortal {
    public static void main(String[] args) {

        TrainingProgram t1 = new TrainingProgram("Java Full Stack", 6, 45000);
        TrainingProgram t2 = new TrainingProgram("Data Structures", 4, 30000);

        t1.showProgramInfo();
        System.out.println("-------------------");
        t2.showProgramInfo();
        System.out.println();

        TrainingProgram.changeAcademyName("XYZ Technologies");

        t1.showProgramInfo();
        System.out.println("-------------------");
        t2.showProgramInfo();
    }
}
