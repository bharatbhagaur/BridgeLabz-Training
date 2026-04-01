public class PeakElementBinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 3, 20, 4, 1, 0};

        int index = findPeakElement(arr);

        System.out.println("Peak element index: " + index);
        System.out.println("Peak element value: " + arr[index]);
    }

    // Method to find a peak element using Binary Search
    static int findPeakElement(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            boolean leftOk = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            if (leftOk && rightOk) {
                return mid;
            }

            // If left neighbor is greater, peak lies on left side
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else peak lies on right side
            else {
                left = mid + 1;
            }
        }

        return -1; // Should never reach here
    }
}
