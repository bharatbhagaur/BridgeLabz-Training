import java.time.LocalDate;   // class to work with dates
import java.util.Scanner;    // scanner for user input

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // scanner object

        // Take date input from user
        System.out.print("Enter date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();

        // Convert input string to LocalDate
        LocalDate givenDate = LocalDate.parse(inputDate);

        // Add 7 days to the date
        LocalDate afterDays = givenDate.plusDays(7);

        // Add 1 month
        LocalDate afterMonth = afterDays.plusMonths(1);

        // Add 2 years
        LocalDate afterYears = afterMonth.plusYears(2);

        // Subtract 3 weeks
        LocalDate finalDate = afterYears.minusWeeks(3);

        // Display results step by step
        System.out.println("Original Date: " + givenDate);
        System.out.println("After adding 7 days: " + afterDays);
        System.out.println("After adding 1 month: " + afterMonth);
        System.out.println("After adding 2 years: " + afterYears);
        System.out.println("After subtracting 3 weeks: " + finalDate);
    }
}
