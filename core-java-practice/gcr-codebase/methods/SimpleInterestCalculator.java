import java.util.Scanner;

public class SimpleInterestCalculator {

    // Method to calculate simple interest
    static double calculateSI(double principalAmt, double interestRate, double timePeriod) {
        return (principalAmt * interestRate * timePeriod) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time: ");
        double time = sc.nextDouble();

        // Calling method
        double simpleInterest = calculateSI(principal, rate, time);

        // Output
        System.out.println("The Simple Interest is " + simpleInterest +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time);
    }
}
