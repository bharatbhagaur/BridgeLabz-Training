public class HeapSortJobSalaries {

    public static void main(String[] args) {

        // Step 1: Declare and initialize array of salary demands
        int[] salaries = {45000, 70000, 30000, 90000, 55000};

        // Step 2: Perform heap sort
        heapSort(salaries);

        // Step 3: Display sorted salary demands
        System.out.println("Job applicants' salaries in ascending order:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }

    // Step 4: Heap Sort method
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 5: Build Max Heap
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 6: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Swap root (largest) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Step 7: Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Step 8: Heapify a subtree rooted at index i
    static void heapify(int[] arr, int heapSize, int i) {

        int largest = i;          // Assume root is largest
        int left = 2 * i + 1;     // Left child index
        int right = 2 * i + 2;    // Right child index

        // Step 9: If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // Step 10: If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // Step 11: If largest is not root, swap and continue heapifying
        if (largest != i) {

            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, heapSize, largest);
        }
    }
}
