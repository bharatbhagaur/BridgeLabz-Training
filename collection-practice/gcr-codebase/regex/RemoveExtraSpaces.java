public class RemoveExtraSpaces {
    public static void main(String[] args) {

        // Input string with multiple spaces
        String text = "This   is    an  example   with   multiple   spaces.";

        /*
         * Regex Explanation:
         * \\s+  -> matches one or more whitespace characters
         */
        String regex = "\\s+";

        // replaceAll() replaces all matched patterns with single space
        String result = text.replaceAll(regex, " ");

        // Print cleaned text
        System.out.println(result);
    }
}
