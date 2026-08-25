public class PassWordValidation
 {

    // Version 1: Single Regex
    static boolean isStrongPasswordRegex(String pw) {
        String regex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$";

        return pw.matches(regex);
    }

    // Version 2: Separate Checks
    static boolean isStrongPasswordChecks(String pw) {

        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : pw.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            }

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            if ("!@#$%^&*".indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        return pw.length() >= 8
            && hasLowercase
            && hasUppercase
            && hasDigit
            && hasSpecial;
    }

    public static void main(String[] args) {

        String[] passwords = {
            "Ab1!",          // Too short
            "abcdefg1!",     // No uppercase
            "Abcdefgh!",     // No digit
            "Abcdefg1",      // No special character
            "Abcd1234!"      // Valid
        };

        for (String password : passwords) {

            boolean result1 = isStrongPasswordRegex(password);
            boolean result2 = isStrongPasswordChecks(password);

            System.out.println(
                password + " -> Regex: " + result1
                + ", Separate Checks: " + result2
                + ", Agree: " + (result1 == result2)
            );
        }

        System.out.println();

        System.out.println(
            "For a real signup form, I would choose separate checks because they are easier to maintain and can give users specific feedback."
        );
    }
}