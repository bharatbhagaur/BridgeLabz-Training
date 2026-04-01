import java.util.*;

public class FrequencyOfElements {

    // Method to count frequency of strings
    static Map<String, Integer> countFrequency(List<String> list) {

        // HashMap to store element -> frequency
        Map<String, Integer> freqMap = new HashMap<>();

        // Traverse each element in the list
        for (String item : list) {

            // If key already exists, increase count
            if (freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            }
            // If key does not exist, insert with count = 1
            else {
                freqMap.put(item, 1);
            }
        }
        return freqMap;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // List to store user input
        List<String> list = new ArrayList<>();

        // Take string input
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Count frequency
        Map<String, Integer> result = countFrequency(list);

        // Print result
        System.out.println("Frequency Map: " + result);

        sc.close();
    }
}
