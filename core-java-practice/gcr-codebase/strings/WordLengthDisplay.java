import java.util.Scanner;

class WordLengthDisplay {

    // Method to calculate length of string without using length()
    static int calculateLength(String value) {

        int count = 0;

        try {
            // Loop will run until index goes out of range
            for (;;) {
                value.charAt(count);   // accessing character
                count++;               // increase counter
            }
        } catch (Exception e) {
            // Exception occurs when index exceeds string size
            // Loop stops automatically
        }

        return count;
    }

    // Method to split sentence into words using charAt()
    static String[] manualWordSplit(String sentence) {

        int totalLen = calculateLength(sentence);
        int wordTotal = 1;

        // Counting spaces to find total words
        for (int i = 0; i < totalLen; i++) {
            if (sentence.charAt(i) == ' ') {
                wordTotal++;
            }
        }

        String[] wordList = new String[wordTotal];
        String current = "";
        int position = 0;

        // Creating each word manually
        for (int i = 0; i < totalLen; i++) {
            if (sentence.charAt(i) != ' ') {
                current = current + sentence.charAt(i);
            } else {
                wordList[position] = current;
                position++;
                current = "";
            }
        }

        // Storing the last word
        wordList[position] = current;

        return wordList;
    }

    // Method to create 2D array of word and its length
    static String[][] createWordLengthTable(String[] wordArr) {

        String[][] table = new String[wordArr.length][2];

        for (int i = 0; i < wordArr.length; i++) {
            table[i][0] = wordArr[i];                              // word
            table[i][1] = String.valueOf(calculateLength(wordArr[i])); // length as string
        }

        return table;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking full sentence input
        System.out.print("Enter any text: ");
        String inputText = sc.nextLine();

        // Splitting words using user logic
        String[] words = manualWordSplit(inputText);

        // Creating 2D table of words and length
        String[][] resultTable = createWordLengthTable(words);

        // Displaying result in tabular format
        System.out.println("Word\tLength");
        for (int i = 0; i < resultTable.length; i++) {
            System.out.println(resultTable[i][0] + "\t"
                    + Integer.parseInt(resultTable[i][1]));
        }
    }
}
