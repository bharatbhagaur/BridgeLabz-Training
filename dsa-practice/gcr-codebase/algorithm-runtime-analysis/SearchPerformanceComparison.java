import java.util.Arrays;

public class SearchPerformanceComparison {

    public static void main(String[] args) {

        int n = 1_000_000;               // Dataset size
        int target = n - 1;              // Element to search (worst case)
        int[] data = new int[n];

        // Fill array with values 0 to n-1
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        // ---------------- Linear Search ----------------
        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();

        long linearTime = endLinear - startLinear;

        // ---------------- Binary Search ----------------
        // Array is already sorted, so no need to sort again
        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();

        long binaryTime = endBinary - startBinary;

        // ---------------- Results ----------------
        System.out.println("Dataset size: " + n);
        System.out.println("Linear Search Time : " + linearTime + " ns");
        System.out.println("Binary Search Time : " + binaryTime + " ns");
    }

    // Linear Search method (O(N))
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search method (O(log N))
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
