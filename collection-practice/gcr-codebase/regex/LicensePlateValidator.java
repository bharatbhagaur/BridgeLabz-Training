import java.util.Scanner;

public class LicensePlateValidator {
    public static void main(String[] args) {

        // Take input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter license plate number: ");
        String plate = sc.nextLine();

        /*
         * Regex Explanation:
         * ^        -> start of string
         * [A-Z]{2} -> exactly two uppercase letters
         * [0-9]{4} -> exactly four digits
         * $        -> end of string
         */
        String regex = "^[A-Z]{2}[0-9]{4}$";

        // Validate using matches()
        if (plate.matches(regex)) {
            System.out.println("Valid License Plate ");
        } else {
            System.out.println("Invalid License Plate ");
        }

    
    }
}
