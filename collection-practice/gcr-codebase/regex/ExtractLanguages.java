import java.util.regex.*;

public class ExtractLanguages {
    public static void main(String[] args) {

        // Given text
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        /*
         * Regex Explanation:
         * \\b[A-Z][a-zA-Z]*\\b
         * - word starting with capital letter
         */
        String regex = "\\b[A-Z][a-zA-Z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find and print words (ignore single-letter like "I")
        while (matcher.find()) {
            String word = matcher.group();

            // Skip single-letter words
            if (word.length() > 1) {
                System.out.println(word);
            }
        }
    }
}
