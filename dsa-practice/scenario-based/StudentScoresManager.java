import java.util.Scanner;

public class StudentScoresManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        // Input number of students with validation
        while (true) {
            System.out.print("Enter number of students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Number of students must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear invalid input
            }
        }

        // Array to store student scores
        double[] scores = new double[n];

        // Taking scores input with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");

                if (sc.hasNextDouble()) {
                    double score = sc.nextDouble();

                    if (score >= 0) {
                        scores[i] = score;
                        break;
                    } else {
                        System.out.println("Score cannot be negative.");
                    }
                } else {
                    System.out.println("Invalid input! Enter numeric value.");
                    sc.next(); // clear invalid input
                }
            }
        }

        // Initialize values
        double sum = 0;
        double highest = scores[0];
        double lowest = scores[0];

        // Calculate sum, highest and lowest
        for (double score : scores) {
            sum += score;

            if (score > highest)
                highest = score;

            if (score < lowest)
                lowest = score;
        }

        // Calculate average
        double average = sum / n;

        // Display results
        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        // Display scores above average
        System.out.println("\nScores above average:");
        boolean found = false;

        for (double score : scores) {
            if (score > average) {
                System.out.println(score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No scores above average.");
        }

        
    }
}

