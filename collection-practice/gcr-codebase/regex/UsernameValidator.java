import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {

        // Scanner for taking user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter username
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";

        // matches() checks if entire string follows the regex pattern
        if (username.matches(regex)) {
            System.out.println("Valid Username ");
        } else {
            System.out.println("Invalid Username ");
        }

       
    }
}