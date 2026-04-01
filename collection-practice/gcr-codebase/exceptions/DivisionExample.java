import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Ask user for first number
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();   // may throw InputMismatchException

            // Ask user for second number
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();   // may throw InputMismatchException

            // Division (may throw ArithmeticException if num2 = 0)
            int result = num1 / num2;

            // Print result if no exception
            System.out.println("Result: " + result);
        }

        // If user enters non-numeric value
        catch (InputMismatchException e) {
            System.out.println("Please enter only numeric values.");
        }

        // If division by zero happens
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }

        // Close scanner
        finally {
            sc.close();
        }
    }
}
