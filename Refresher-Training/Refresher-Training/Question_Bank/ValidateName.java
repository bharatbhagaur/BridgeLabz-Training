class InvalidNameException extends Exception {

    InvalidNameException(String message) {
        super(message);
    }
}

public class ValidateName {

    static boolean validateName(String name) throws InvalidNameException {

        if (name != null && name.matches("[a-zA-Z ]+")) {
            return true;
        }

        throw new InvalidNameException("Invalid name");
    }

    public static void main(String[] args) {

        String name = "Bharat Singh";

        try {
            if (validateName(name)) {
                System.out.println("Valid");
            }
        } 
        catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        }
    }
}