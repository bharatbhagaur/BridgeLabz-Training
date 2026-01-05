import java.util.*;

public class GenerateBinaryNumbers {

    // Method to generate first N binary numbers
    static List<String> generateBinary(int n) {

        List<String> result = new ArrayList<>();

        // Edge case
        if (n <= 0) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();

        // Start with "1"
        queue.add("1");

        // Generate N binary numbers
        for (int i = 0; i < n; i++) {

            // Remove front binary number
            String current = queue.remove();

            // Add it to result list
            result.add(current);

            // Generate next two binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take N as input
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        // Generate binary numbers
        List<String> binaryNumbers = generateBinary(n);

        // Print output
        System.out.println("First " + n + " binary numbers:");
        System.out.println(binaryNumbers);

        sc.close();
    }
}
