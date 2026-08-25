import java.util.*;

public class CommonWordLength {

    public static int mostCommonWordLength(String str) {

        String[] words = str.split("\\s+");

        int[] frequency = new int[100];

        // Count word lengths
        for (String word : words) {

            int length = word.length();

            frequency[length]++;
        }

        // Find most frequent length
        int maxFrequency = 0;
        int result = 0;

        for (int i = 0; i < frequency.length; i++) {

            if (frequency[i] > maxFrequency) {

                maxFrequency = frequency[i];
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String str = "I love java programming coding";

        System.out.println(mostCommonWordLength(str));
    }
}