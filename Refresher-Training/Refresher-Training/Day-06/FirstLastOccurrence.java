//FirstLastOccurrence
public class FirstLastOccurrence {

    static int firstComparisons = 0;
    static int lastComparisons = 0;

    // Find First Occurrence
    public static int findFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            firstComparisons++;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // Search left half
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Find Last Occurrence
    public static int findLast(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            lastComparisons++;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // Search right half
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 4, 7, 9, 9, 12};
        int[] targets = {4, 9, 5};

        for (int target : targets) {

            firstComparisons = 0;
            lastComparisons = 0;

            int first = findFirst(arr, target);
            int last = findLast(arr, target);

            System.out.println("Target = " + target);
            System.out.println("First Occurrence = " + first);
            System.out.println("Last Occurrence  = " + last);
            System.out.println("First Search Comparisons = " + firstComparisons);
            System.out.println("Last Search Comparisons  = " + lastComparisons);
            System.out.println();
        }
    }
}