public class MergeSortBookPrices {

    public static void main(String[] args) {

        // Step 1: Declare and initialize array of book prices
        int[] prices = {450, 299, 799, 150, 999, 350};

        // Step 2: Call merge sort on the full array
        mergeSort(prices, 0, prices.length - 1);

        // Step 3: Display sorted book prices
        System.out.println("Book prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }

    // Step 4: Recursive function to divide the array
    static void mergeSort(int[] arr, int left, int right) {

        // Base condition: if array has more than one element
        if (left < right) {

            // Step 5: Find middle index
            int mid = left + (right - left) / 2;

            // Step 6: Recursively sort left half
            mergeSort(arr, left, mid);

            // Step 7: Recursively sort right half
            mergeSort(arr, mid + 1, right);

            // Step 8: Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Step 9: Merge two sorted subarrays
    static void merge(int[] arr, int left, int mid, int right) {

        // Step 10: Find sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Step 11: Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Step 12: Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        // Step 13: Merge the temporary arrays
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Step 14: Copy remaining elements of leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Step 15: Copy remaining elements of rightArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
