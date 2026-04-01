public class RotationPointBinarySearch {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        int index = findRotationPoint(arr);

        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);
    }

    // Method to find index of smallest element
    static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If middle element is greater than right,
            // smallest element is in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Otherwise, smallest element is in left half (including mid)
            else {
                right = mid;
            }
        }

        // left == right points to smallest element
        return left;
    }
}
