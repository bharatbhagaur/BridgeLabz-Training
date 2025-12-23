import java.util.Scanner;

public class StringProblems {

    // 1️ Method to count vowels and consonants
    static void countVowelsAndConsonants(String text) {

        int vowelCount = 0;      // stores number of vowels
        int consonantCount = 0;  // stores number of consonants

        // loop through each character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i); // get character at index

            // check if character is a letter
            if (Character.isLetter(ch)) {

                // convert to lowercase for easy comparison
                ch = Character.toLowerCase(ch);

                // check vowel condition
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                    vowelCount++;      // increase vowel count
                } else {
                    consonantCount++;  // increase consonant count
                }
            }
        }

        // display result
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
    }

    // 2️ Method to reverse a string
    static String reverseString(String text) {

        String reversed = ""; // empty string to store result

        // loop from last character to first
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i); // add character
        }

        return reversed; // return reversed string
    }

    // 3️ Method to check palindrome
    static boolean isPalindrome(String text) {

        // reverse the string using our own method
        String reversed = reverseString(text);

        // compare original and reversed
        return text.equals(reversed);
    }

    // 4️ Method to remove duplicate characters
    static String removeDuplicates(String text) {

        String result = ""; // store unique characters

        // loop through string
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i); // current character

            // check if character already exists in result
            if (result.indexOf(ch) == -1) {
                result = result + ch; // add only if not present
            }
        }

        return result; // return string without duplicates
    }

    // 5️ Method to find longest word in a sentence
    static String findLongestWord(String sentence) {

        String[] words = sentence.split(" "); // split sentence into words
        String longestWord = "";              // store longest word

        // loop through words
        for (String word : words) {

            // check length
            if (word.length() > longestWord.length()) {
                longestWord = word; // update longest word
            }
        }

        return longestWord; // return result
    }

    // 6️ Method to count substring occurrences
    static int countSubstring(String text, String sub) {

        int count = 0;  // stores number of occurrences
        int index = 0;  // starting index

        // loop until substring not found
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;              // increase count
            index = index + sub.length(); // move index forward
        }

        return count; // return total count
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // scanner object

        System.out.print("Enter a string: ");
        String input = sc.nextLine(); // take string input

        // 1️ Count vowels and consonants
        countVowelsAndConsonants(input);

        // 2️ Reverse string
        System.out.println("Reversed String: " + reverseString(input));

        // 3️ Palindrome check
        if (isPalindrome(input))
            System.out.println("String is Palindrome");
        else
            System.out.println("String is Not Palindrome");

        // 4️ Remove duplicates
        System.out.println("Without Duplicates: " + removeDuplicates(input));

        // 5️ Longest word
        System.out.println("Longest Word: " + findLongestWord(input));

        // 6️ Substring occurrence
        System.out.print("Enter substring to search: ");
        String sub = sc.nextLine(); // substring input

        System.out.println("Substring Occurrences: " +
                countSubstring(input, sub));
    }
}
