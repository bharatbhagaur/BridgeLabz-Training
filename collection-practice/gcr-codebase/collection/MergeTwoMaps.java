import java.util.*;

public class MergeTwoMaps {

    // Method to merge two maps
    static Map<String, Integer> mergeMaps(
            Map<String, Integer> map1,
            Map<String, Integer> map2) {

        Map<String, Integer> result = new HashMap<>();

        // Step 1: Copy all entries from map1
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        // Step 2: Merge entries from map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            // If key exists, sum the values
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + value);
            } else {
                result.put(key, value);
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // -------- Input for Map 1 --------
        System.out.print("Enter number of entries in Map 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter key and value for Map 1:");
        for (int i = 0; i < n1; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map1.put(key, value);
        }

        // -------- Input for Map 2 --------
        System.out.print("\nEnter number of entries in Map 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter key and value for Map 2:");
        for (int i = 0; i < n2; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map2.put(key, value);
        }

        // -------- Merge Maps --------
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // -------- Output --------
        System.out.println("\nMerged Map: " + mergedMap);

        sc.close();
    }
}
