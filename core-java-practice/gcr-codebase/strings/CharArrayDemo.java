import java.util.Scanner;

class CharArrayDemo {

    // user-defined method to get characters
    static char[] getCharacters(String text) {

        char[] arr = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    // compare two char arrays
    static boolean compareArrays(char[] a, char[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        char[] customArray = getCharacters(input);
        char[] builtInArray = input.toCharArray();

        boolean result = compareArrays(customArray, builtInArray);

        System.out.println("Characters using user method:");
        for (char c : customArray) {
            System.out.print(c + " ");
        }

        System.out.println("\nAre both arrays same? " + result);

        sc.close();
    }
}
