import java.util.Scanner;

class SubstringCheck {

    // create substring using charAt
    static String createSubString(String text, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }
        return result;
    }

    // compare strings using charAt
    static boolean compareStrings(String a, String b) {

        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String manualSub = createSubString(text, start, end);
        String builtInSub = text.substring(start, end);

        boolean result = compareStrings(manualSub, builtInSub);

        System.out.println("Substring using charAt: " + manualSub);
        System.out.println("Substring using built-in: " + builtInSub);
        System.out.println("Are both substrings same? " + result);

        sc.close();
    }
}
