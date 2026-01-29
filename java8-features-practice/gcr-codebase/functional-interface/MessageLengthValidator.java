package functionalinterface;

import java.util.function.Function;

public class MessageLengthValidator {

    public static void main(String[] args) {

        int characterLimit = 25;

        // Function functional interface to calculate length of string
        Function<String, Integer> lengthCalculator = messageText -> {
            return messageText.length();
        };

        String firstMessage = "System status updated successfully";
        String secondMessage = "OK";

        verifyMessage(firstMessage, characterLimit, lengthCalculator);
        verifyMessage(secondMessage, characterLimit, lengthCalculator);
    }

    private static void verifyMessage(String message,
                                      int limit,
                                      Function<String, Integer> calculator) {

        int messageLength = calculator.apply(message);

        if (messageLength > limit) {
            System.out.println("Message exceeds character limit. Length: " + messageLength);
        } else {
            System.out.println("Message is within allowed limit. Length: " + messageLength);
        }
    }
}
