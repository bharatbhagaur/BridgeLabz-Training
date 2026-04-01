package functionalinterface;

interface SecurityUtils {

    // Static method inside interface
    static boolean isStrongPassword(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit;
    }
}

public class PasswordValidatorApp {

    public static void main(String[] args) {

        String passwordOne = "Admin123";
        String passwordTwo = "simple";

        validatePassword(passwordOne);
        validatePassword(passwordTwo);
    }

    private static void validatePassword(String password) {

        boolean result = SecurityUtils.isStrongPassword(password);

        if (result) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}
