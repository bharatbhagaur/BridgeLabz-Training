public class PenDistribution {
    public static void main(String[] args) {

        int totalPens = 14;        // Total pens available
        int studentCount = 3;      // Number of students

        int pensEach = totalPens / studentCount;   // Pens per student
        int leftoverPens = totalPens % studentCount; // Pens left undistributed

        System.out.println("Each student gets: " + pensEach + " pens");
        System.out.println("Remaining pens: " + leftoverPens);
    }
}
