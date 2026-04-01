import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    // Method to count word frequency from a file
    static Map<String, Integer> countWordFrequency(String filePath) {

        Map<String, Integer> wordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");

                // Split line into words
                String[] words = line.split("\\s+");

                // Count frequency
                for (String word : words) {

                    // Skip empty words
                    if (word.isEmpty()) continue;

                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return wordMap;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take file path from user
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        // Count word frequencies
        Map<String, Integer> result = countWordFrequency(filePath);

        // Print result
        System.out.println("Word Frequency:");
        System.out.println(result);

        sc.close();
    }
}
