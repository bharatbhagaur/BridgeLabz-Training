import java.util.*;

public class NthElementFromEnd {

    // Method to find Nth element from end
    static String findNthFromEnd(LinkedList<String> list, int n) {

        // Edge case: invalid N
        if (n <= 0 || n > list.size()) {
            return "Invalid N value";
        }

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        // Move fast pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            }
        }

        // Move both pointers until fast reaches end
        String result = null;
        while (fast.hasNext()) {
            fast.next();
            result = slow.next();
        }

        // If result is null, Nth from end is first element
        if (result == null) {
            result = slow.next();
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Create LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Take list input
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Take N
        System.out.print("Enter N (Nth element from end): ");
        int N = sc.nextInt();

        // Find and print result
        String result = findNthFromEnd(list, N);
        System.out.println("Nth element from end: " + result);

        sc.close();
    }
}
