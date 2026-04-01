import java.util.Scanner;

class WordSplitCheck {

    // Method to calculate string length without using length()
    static int calculateLength(String value) {

        int count = 0;

        try {
            // Infinite loop to count characters
            while (true) {
                value.charAt(count);  // accessing each character
                count++;
            }
        } catch (Exception e) {
            // Exception occurs when index goes out of range
            // Loop stops here
        }

        return count;
    }

    // Method to split string into words using charAt()
    static String[] splitUsingLogic(String sentence) {

        int totalLength = calculateLength(sentence);
        int words = 1;

        // Counting number of words by checking spaces
        for (int i = 0; i < totalLength; i++) {
            if (sentence.charAt(i) == ' ') {
                words++;
            }
        }

        String[] result = new String[words];
        int pos = 0;
        String word = "";

        // Creating words manually
        for (int i = 0; i < totalLength; i++) {
            if (sentence.charAt(i) != ' ') {
                word = word + sentence.charAt(i);
            } else {
                result[pos] = word;
                pos++;
                word = "";
            }
        }

        // Storing last word
        result[pos] = word;

        return result;
    }

    // Method to compare two string arrays
    static boolean checkSame(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking full sentence input
        System.out.print("Enter any sentence: ");
        String inputText = sc.nextLine();

        // Splitting using user logic
        String[] manualResult = splitUsingLogic(inputText);

        // Splitting using built-in method
        String[] systemResult = inputText.split(" ");

        // Comparing both results
        boolean finalResult = checkSame(manualResult, systemResult);

        // Displaying comparison result
        System.out.println("Both splitting methods give same result: " + finalResult);

        
    }
}
