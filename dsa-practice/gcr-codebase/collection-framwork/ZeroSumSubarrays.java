// Import required classes
import java.util.ArrayList;
import java.util.HashMap;

public class ZeroSumSubarrays {

    // -------- Method to find all zero-sum subarrays --------
    static void findZeroSumSubarrays(int[] arr) {

        // HashMap to store cumulative sum and its indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Variable to store cumulative sum
        int sum = 0;

        // Traverse array
        for (int i = 0; i < arr.length; i++) {

            // Add current element to cumulative sum
            sum += arr[i];

            // If cumulative sum is zero, subarray from 0 to i is zero-sum
            if (sum == 0) {
                System.out.println("Subarray found from index 0 to " + i);
            }

            // If sum already exists in map
            if (map.containsKey(sum)) {

                // Get all previous indices with same sum
                ArrayList<Integer> list = map.get(sum);

                // For each index, print subarray
                for (int startIndex : list) {
                    System.out.println(
                            "Subarray found from index " +
                            (startIndex + 1) + " to " + i
                    );
                }

                // Add current index to list
                list.add(i);
            }
            else {
                // Create new list for this sum
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sum, list);
            }
        }
    }

    // -------- Main method --------
    public static void main(String[] args) {

        // Input array
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};

        // Call method
        findZeroSumSubarrays(arr);
    }
}

