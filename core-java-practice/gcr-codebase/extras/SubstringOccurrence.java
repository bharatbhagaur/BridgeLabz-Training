import java.util.Scanner;

public class SubstringOccurrence {

    // Method to count substring occurrences
    static int countOccurrences(String text, String sub) {

        int count = 0;   // occurrence count
        int index = 0;   // search index

        // loop until substring not found
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length();
        }

        return count; // return count
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String text = sc.nextLine();

        System.out.print("Enter substring: ");
        String sub = sc.nextLine();

        System.out.println("Occurrences: " +
                countOccurrences(text, sub));
    }
}
