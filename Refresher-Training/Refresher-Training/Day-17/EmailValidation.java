import java.util.*;

public class EmailValidation {

    public static boolean isValidEmail(String email) {
        return email.matches(
            "^(?!.*\\.\\.)[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }

    public static void main(String[] args) {

        String[] validEmails = {
            "john@gmail.com",
            "user123@yahoo.com",
            "hello.world@company.co.in",
            "test+java@gmail.com",
            "user_name123@domain.org"
        };

        String[] invalidEmails = {
            "johngmail.com",
            "john@gmail",
            "john..doe@gmail.com",
            "john@.com",
            "john@gmail.c"
        };

        System.out.println("Valid Emails:");

        for (String email : validEmails) {
            System.out.println(email + " -> " + isValidEmail(email));
        }

        System.out.println("\nInvalid Emails:");

        for (String email : invalidEmails) {
            System.out.println(email + " -> " + isValidEmail(email));
        }
    }
}