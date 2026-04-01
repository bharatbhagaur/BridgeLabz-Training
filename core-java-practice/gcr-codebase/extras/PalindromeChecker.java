import java.util.Scanner;

public class PalindromeChecker {

    // Method to check palindrome
    static boolean checkPalindrome(String text) {

        String reversed = "";

        // reverse the string manually
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        // compare original and reversed string
        return text.equalsIgnoreCase(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (checkPalindrome(input))
            System.out.println("String is Palindrome");
        else
            System.out.println("String is Not Palindrome");
    }
}
