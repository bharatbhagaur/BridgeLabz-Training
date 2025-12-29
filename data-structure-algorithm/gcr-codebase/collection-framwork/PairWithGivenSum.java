// Import HashMap class
import java.util.HashMap;

public class PairWithGivenSum {

    // -------- Method to check if pair exists --------
    static boolean hasPairWithSum(int[] arr, int target) {

        // HashMap to store visited elements
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Traverse array
        for (int num : arr) {

            // Calculate required complement
            int complement = target - num;

            // If complement already exists, pair found
            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + num + " + " + complement + " = " + target);
                return true;
            }

            // Store current number in map
            map.put(num, true);
        }

        // If no pair found
        return false;
    }

    // -------- Main method --------
    public static void main(String[] args) {

        // Input array
        int[] arr = {8, 7, 2, 5, 3, 1};

        // Target sum
        int target = 10;

        // Check for pair
        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair found with given sum.");
        }
    }
}
