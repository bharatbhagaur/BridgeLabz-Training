import java.util.regex.*;

public class ExtractEmails {
    public static void main(String[] args) {

        // Given text
        String text = "Contact us at support@example.com and info@company.org";

       
        String regex = "[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]{2,}";

        // Compile regex into Pattern
        Pattern pattern = Pattern.compile(regex);

        // Match pattern with text
        Matcher matcher = pattern.matcher(text);

        // find() searches for next match in text
        while (matcher.find()) {
            // group() gives the matched string
            System.out.println(matcher.group());
        }
    }
}

