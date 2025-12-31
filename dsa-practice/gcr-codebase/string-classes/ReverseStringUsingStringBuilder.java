public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {

        String input = "hello";

        // Create StringBuilder and append the input string
        StringBuilder sb = new StringBuilder(input);

        // Reverse the string using StringBuilder's method
        sb.reverse();

        // Convert StringBuilder back to String
        String reversedString = sb.toString();

        // Print the reversed string
        System.out.println("Reversed String: " + reversedString);
    }
}
