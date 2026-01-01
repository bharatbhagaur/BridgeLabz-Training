import java.util.Scanner;

public class ParagraphAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take paragraph input from user
        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine();

        // Trim paragraph to handle extra spaces
        paragraph = paragraph.trim();

        // Edge case: empty paragraph or only spaces
        if (paragraph.isEmpty()) {
            System.out.println("Paragraph is empty. No analysis possible.");
            return;
        }

        // ---------------- Word Count ----------------
        // Split paragraph by one or more spaces
        String[] words = paragraph.split("\\s+");
        int wordCount = words.length;

        // ---------------- Find Longest Word ----------------
        String longestWord = words[0];

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // ---------------- Word Replacement ----------------
        System.out.println("Enter the word to replace:");
        String oldWord = scanner.nextLine();

        System.out.println("Enter the new word:");
        String newWord = scanner.nextLine();

        // Replace word (case-insensitive)
        String replacedParagraph = paragraph.replaceAll(
                "(?i)\\b" + oldWord + "\\b",
                newWord
        );

        // ---------------- Output Results ----------------
        System.out.println("\n--- Analysis Result ---");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Updated Paragraph:");
        System.out.println(replacedParagraph);

        scanner.close();
    }
}
