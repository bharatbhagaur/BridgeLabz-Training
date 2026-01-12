import java.util.regex.*;

public class ExtractCapitalWords {
    public static void main(String[] args) {

        // Given sentence
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        /*
         * Regex Explanation:
         * \\b        -> word boundary (start)
         * [A-Z]     -> first letter must be capital
         * [a-z]*    -> remaining letters (0 or more)
         * \\b       -> word boundary (end)
         */
        String regex = "\\b[A-Z][a-z]*\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);

        // Match with text
        Matcher matcher = pattern.matcher(text);

        // Find and print all capitalized words
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

