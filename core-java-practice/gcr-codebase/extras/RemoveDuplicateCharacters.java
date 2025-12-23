import java.util.Scanner;

public class RemoveDuplicateCharacters {

    // Method to remove duplicates
    static String removeDuplicates(String text) {

        String result = ""; // store unique characters

        // loop through string
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // add only if not already present
            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }
        }

        return result; // return final string
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("After Removing Duplicates: " +
                removeDuplicates(input));
    }
}
