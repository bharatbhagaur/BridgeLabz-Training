import java.util.regex.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {

        // Given text
        String text = "The price is $45.99, and the discount is 10.50.";

        /*
         * Regex Explanation:
         * \\$?      -> optional dollar symbol
         * \\d+      -> one or more digits
         * \\.       -> decimal point
         * \\d{2}    -> exactly two digits after decimal
         */
        String regex = "\\$?\\d+\\.\\d{2}";

        // Compile regex
        Pattern pattern = Pattern.compile(regex);

        // Match with text
        Matcher matcher = pattern.matcher(text);

        // Find and print all currency values
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
