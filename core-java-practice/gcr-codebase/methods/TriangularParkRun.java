
import java.util.Scanner;

public class TriangularParkRun {

    // Method to calculate required rounds
    static double calculateRounds(double sideA, double sideB, double sideC) {
        double perimeter = sideA + sideB + sideC;
        double totalDistance = 5000; // meters (5 km)
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first side of triangle (meters): ");
        double a = sc.nextDouble();

        System.out.print("Enter second side of triangle (meters): ");
        double b = sc.nextDouble();

        System.out.print("Enter third side of triangle (meters): ");
        double c = sc.nextDouble();

        double rounds = calculateRounds(a, b, c);

        System.out.println("Athlete needs to complete " + rounds + " rounds to cover 5 km");
    }
}
