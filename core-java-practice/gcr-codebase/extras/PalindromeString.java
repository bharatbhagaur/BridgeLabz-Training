import java.util.Scanner;

public class PalindromeString {

    // Method to check palindrome
    static boolean checkPalindrome(String text) {

        String reverse = "";

        // reverse string manually
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }

        return text.equals(reverse); // compare both strings
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
