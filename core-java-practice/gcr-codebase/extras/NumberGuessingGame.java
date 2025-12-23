import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    // Method to generate computer guess
    static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }

    // Method to get user feedback
    static String getFeedback(Scanner sc) {
        System.out.print("Enter feedback (high / low / correct): ");
        return sc.nextLine();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int lowerLimit = 1;    // minimum range
        int upperLimit = 100;  // maximum range
        boolean guessed = false;

        System.out.println("Think of a number between 1 and 100");

        // loop until correct guess
        while (!guessed) {

            int computerGuess = generateGuess(lowerLimit, upperLimit);
            System.out.println("Computer guesses: " + computerGuess);

            String feedback = getFeedback(sc);

            if (feedback.equalsIgnoreCase("high")) {
                upperLimit = computerGuess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                lowerLimit = computerGuess + 1;
            } else if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed the number correctly!");
                guessed = true;
            } else {
                System.out.println("Invalid input, try again");
            }
        }
    }
}
