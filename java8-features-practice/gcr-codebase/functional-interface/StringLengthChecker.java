package functionalinterface;

import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int maximumCharactersAllowed = 20;

        // Function functional interface to compute length of a message
        Function<String, Integer> messageLengthFunction = text -> {
            return text.length();
        };

        String messageOne = "Application deployed successfully";
        String messageTwo = "Done";

        evaluateMessage(messageOne, maximumCharactersAllowed, messageLengthFunction);
        evaluateMessage(messageTwo, maximumCharactersAllowed, messageLengthFunction);
    }

    private static void evaluateMessage(String message,
                                        int limit,
                                        Function<String, Integer> lengthFunction) {

        int calculatedLength = lengthFunction.apply(message);

        if (calculatedLength > limit) {
            System.out.println("Message exceeds the character limit. Length: " + calculatedLength);
        } else {
            System.out.println("Message is within the character limit. Length: " + calculatedLength);
        }
    }
}
