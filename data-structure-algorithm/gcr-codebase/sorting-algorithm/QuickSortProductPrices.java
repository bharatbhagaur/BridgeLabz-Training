public class QuickSortProductPrices {

    public static void main(String[] args) {

        // Step 1: Declare and initialize array of product prices
        int[] prices = {999, 299, 450, 150, 799, 350};

        // Step 2: Call quick sort on the full array
        quickSort(prices, 0, prices.length - 1);

        // Step 3: Display sorted product prices
        System.out.println("Product prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }

    // Step 4: Quick Sort recursive function
    static void quickSort(int[] arr, int low, int high) {

        // Apply sorting only if there are at least two elements
        if (low < high) {

            // Step 5: Find the correct position of pivot
            int pivotIndex = partition(arr, low, high);

            // Step 6: Recursively sort elements before pivot
            quickSort(arr, low, pivotIndex - 1);

            // Step 7: Recursively sort elements after pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Step 8: Partition function
    static int partition(int[] arr, int low, int high) {

        // Step 9: Choose the last element as pivot
        int pivot = arr[high];

        // Step 10: Index of smaller element
        int i = low - 1;

        // Step 11: Rearrange elements based on pivot
        for (int j = low; j < high; j++) {

            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {

                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Step 12: Place pivot at its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Step 13: Return pivot index
        return i + 1;
    }
}
