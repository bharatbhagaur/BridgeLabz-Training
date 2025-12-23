import java.util.Scanner;

public class LongestWordFinder {

    // Method to find longest word
    static String getLongestWord(String sentence) {

        String[] words = sentence.split(" "); // split sentence
        String longest = "";                  // longest word

        // loop through words
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest; // return longest word
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        System.out.println("Longest Word: " +
                getLongestWord(input));
    }
}
