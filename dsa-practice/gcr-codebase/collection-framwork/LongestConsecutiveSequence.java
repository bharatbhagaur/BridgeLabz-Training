// Import HashSet class
import java.util.HashSet;

public class LongestConsecutiveSequence {

    // -------- Method to find longest consecutive sequence --------
    static int longestConsecutive(int[] nums) {

        // If array is empty
        if (nums.length == 0) {
            return 0;
        }

        // HashSet to store all elements
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Traverse each element
        for (int num : set) {

            // Check if this number is the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // -------- Main method --------
    public static void main(String[] args) {

        // Input array
        int[] arr = {100, 4, 200, 1, 3, 2};

        // Find result
        int result = longestConsecutive(arr);

        // Print result
        System.out.println("Length of Longest Consecutive Sequence: " + result);
    }
}
