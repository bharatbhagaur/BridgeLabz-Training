import java.util.Scanner;

public class ReverseString {

    // Method to reverse string
    static String reverseText(String text) {

        String reversed = ""; // empty string

        // loop from end to start
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        return reversed; // return reversed string
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Reversed String: " + reverseText(input));
    }
}
