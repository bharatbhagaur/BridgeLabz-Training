import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {

        // Example sentence
        String text = "My SSN is 123-45-6789.";

        /*
         * Regex Explanation:
         * \\b\\d{3}-\\d{2}-\\d{4}\\b
         * - matches SSN format: 123-45-6789
         */
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        // find() searches SSN inside the text
        while (matcher.find()) {
            System.out.println("Valid SSN Found : " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No valid SSN found ");
        }
    }
}
