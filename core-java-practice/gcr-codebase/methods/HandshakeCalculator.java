import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate maximum handshakes
    static int calculateHandshakes(int totalStudents) {
        return (totalStudents * (totalStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int maxHandshakes = calculateHandshakes(students);

        System.out.println("Maximum possible handshakes: " + maxHandshakes);
    }
}

