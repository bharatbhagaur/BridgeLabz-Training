import java.util.Scanner;

// Step 1: Create Custom Exception Class
class InvalidAgeException extends Exception {

    // Constructor to pass message to Exception class
    InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    // Step 2: Method that validates age and throws exception
    static void validateAge(int age) throws InvalidAgeException {

        // If age is less than 18, throw custom exception
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Step 3: Take age input from user
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            // Call validation method
            validateAge(age);

            // If no exception, access is granted
            System.out.println("Access granted!");
        }

        // Step 4: Catch custom exception
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        // Optional: handle wrong input (non-number)
        catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }

        finally {
            sc.close();
        }
    }
}
