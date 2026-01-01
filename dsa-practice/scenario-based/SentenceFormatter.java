import java.util.Scanner;

public class SentenceFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take paragraph input from user
        System.out.println("Enter a paragraph:");
        String input = sc.nextLine();

        // Call method to format the sentence
        String formattedText = formatSentence(input);

        // Print formatted output
        System.out.println("\nFormatted Paragraph:");
        System.out.println(formattedText);

        sc.close();
    }

    // Method to format the paragraph
    static String formatSentence(String text) {

        // Remove extra spaces from beginning and end
        text = text.trim();

        // Replace multiple spaces with single space
        text = text.replaceAll("\\s+", " ");

        // Ensure one space after punctuation marks
        text = text.replaceAll("\\s*([.!?])\\s*", "$1 ");

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        // Traverse each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Capitalize first letter of sentence
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            // After sentence-ending punctuation, capitalize next letter
            if (ch == '.' || ch == '!' || ch == '?') {
                capitalizeNext = true;
            }
        }

        return result.toString().trim();
    }
}
