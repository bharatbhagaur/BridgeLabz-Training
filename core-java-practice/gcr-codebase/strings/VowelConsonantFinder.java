import java.util.Scanner;

class VowelConsonantFinder {

    // This method checks whether a character is vowel, consonant or not a letter
    static String identifyChar(char letter) {

        // Converting uppercase letter to lowercase using ASCII value
        if (letter >= 'A' && letter <= 'Z') {
            letter = (char) (letter + 32);
        }

        // Checking if character is an alphabet
        if (letter >= 'a' && letter <= 'z') {

            // Checking vowel condition
            if (letter == 'a' || letter == 'e' || letter == 'i'
                    || letter == 'o' || letter == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        // If character is not an alphabet
        return "NotLetter";
    }

    // This method counts vowels and consonants in the string
    static int[] countVowelsConsonants(String text) {

        int vowelCount = 0;
        int consonantCount = 0;

        // Loop through each character of string
        for (int i = 0; i < text.length(); i++) {

            String result = identifyChar(text.charAt(i));

            if (result.equals("Vowel")) {
                vowelCount++;
            } else if (result.equals("Consonant")) {
                consonantCount++;
            }
        }

        // Returning count in an array
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input string from user
        System.out.print("Enter any text: ");
        String userText = sc.nextLine();

        // Calling method to count vowels and consonants
        int[] answer = countVowelsConsonants(userText);

        // Displaying final result
        System.out.println("Total vowels are: " + answer[0]);
        System.out.println("Total consonants are: " + answer[1]);

        sc.close();
    }
}
