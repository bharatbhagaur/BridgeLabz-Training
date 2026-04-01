import java.util.Scanner;

class PalindromeCheck {

    // Logic 1: Using start and end index
    static boolean checkPalindromeLoop(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    static boolean checkPalindromeRec(String text, int start, int end) {

        if (start >= end)
            return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return checkPalindromeRec(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays
    static boolean checkPalindromeArray(String text) {

        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reverse[i] = text.charAt(original.length - 1 - i);
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        System.out.println("Loop Logic Result: " + checkPalindromeLoop(input));
        System.out.println("Recursive Logic Result: " +
                checkPalindromeRec(input, 0, input.length() - 1));
        System.out.println("Array Logic Result: " + checkPalindromeArray(input));

        
    }
}
