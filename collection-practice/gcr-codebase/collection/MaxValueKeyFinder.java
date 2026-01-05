import java.util.*;

public class MaxValueKeyFinder {

    // Method to find the key with the maximum value
    static String findKeyWithMaxValue(Map<String, Integer> map) {

        // Edge case: empty map
        if (map.isEmpty()) {
            return "Map is empty";
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Traverse map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            // Compare values
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        // Take number of entries
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Take key-value input
        System.out.println("Enter key and value:");
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map.put(key, value);
        }

        // Find key with maximum value
        String result = findKeyWithMaxValue(map);

        // Output
        System.out.println("Key with highest value: " + result);

        sc.close();
    }
}
