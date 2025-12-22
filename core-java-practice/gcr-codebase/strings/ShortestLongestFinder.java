import java.util.Scanner;

class ShortestLongestFinder {

    // This method finds length of a string without using length()
    static int calculateSize(String value) {

        int count = 0;

        try {
            // Loop runs until index goes out of string range
            for (;;) {
                value.charAt(count);   // accessing character
                count++;               // increment counter
            }
        } catch (Exception e) {
            // Exception occurs when index is invalid
            // Control comes out of loop
        }

        return count;
    }

    // This method splits the sentence into words using charAt()
    static String[] splitText(String sentence) {

        int totalLength = calculateSize(sentence);
        int wordCount = 1;

        // Counting number of words by checking spaces
        for (int i = 0; i < totalLength; i++) {
            if (sentence.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] wordArray = new String[wordCount];
        String currentWord = "";
        int position = 0;

        // Creating each word manually
        for (int i = 0; i < totalLength; i++) {
            if (sentence.charAt(i) != ' ') {
                currentWord = currentWord + sentence.charAt(i);
            } else {
                wordArray[position] = currentWord;
                position++;
                currentWord = "";
            }
        }

        // Storing last word in array
        wordArray[position] = currentWord;

        return wordArray;
    }

    // This method finds shortest and longest word length
    static int[] getMinMaxLength(String[] words) {

        int shortest = calculateSize(words[0]);
        int longest = shortest;

        // Comparing length of each word
        for (int i = 1; i < words.length; i++) {

            int currentLen = calculateSize(words[i]);

            if (currentLen < shortest) {
                shortest = currentLen;
            }

            if (currentLen > longest) {
                longest = currentLen;
            }
        }

        // Returning shortest and longest length
        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking sentence input from user
        System.out.print("Enter any text: ");
        String inputText = sc.nextLine();

        // Splitting sentence into words
        String[] wordList = splitText(inputText);

        // Finding shortest and longest word length
        int[] result = getMinMaxLength(wordList);

        // Displaying result
        System.out.println("Shortest word length is: " + result[0]);
        System.out.println("Longest word length is: " + result[1]);

        sc.close();
    }
}

