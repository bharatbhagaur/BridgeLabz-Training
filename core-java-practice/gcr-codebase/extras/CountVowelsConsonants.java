import java.util.Scanner;

public class CountVowelsConsonants {

    // Method to count vowels and consonants
    static void countLetters(String text) {

        int vowels = 0;       // vowel count
        int consonants = 0;   // consonant count

        // loop through each character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i); // current character

            // check only alphabets
            if (Character.isLetter(ch)) {

                ch = Character.toLowerCase(ch); // convert to lowercase

                // vowel condition
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // scanner object
        System.out.print("Enter a string: ");
        String input = sc.nextLine();        // input string

        countLetters(input);                 // method call
    }
}
