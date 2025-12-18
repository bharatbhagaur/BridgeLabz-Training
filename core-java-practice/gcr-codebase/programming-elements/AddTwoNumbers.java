import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Ask user for first number
        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();

        // Ask user for second number
        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();

        // Calculate sum
        int result = firstNumber + secondNumber;

        // Display result
        System.out.println("Sum = " + result);

        // Close scanner
        scanner.close();
    }
}

