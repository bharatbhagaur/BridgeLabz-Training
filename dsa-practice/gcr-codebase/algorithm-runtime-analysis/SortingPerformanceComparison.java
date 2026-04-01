import java.util.Random;

public class SortingPerformanceComparison {

    public static void main(String[] args) {

        int n = 10_000;   // Change dataset size here (1000, 10000, etc.)
        int[] data = generateArray(n);

        // Create copies so each algorithm works on same data
        int[] bubbleArray = data.clone();
        int[] mergeArray = data.clone();
        int[] quickArray = data.clone();

        // ---------------- Bubble Sort ----------------
        long startBubble = System.nanoTime();
        bubbleSort(bubbleArray);
        long endBubble = System.nanoTime();
        long bubbleTime = endBubble - startBubble;

        // ---------------- Merge Sort ----------------
        long startMerge = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long endMerge = System.nanoTime();
        long mergeTime = endMerge - startMerge;

        // ---------------- Quick Sort ----------------
        long startQuick = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        long endQuick = System.nanoTime();
        long quickTime = endQuick - startQuick;

        // ---------------- Results ----------------
        System.out.println("Dataset Size: " + n);
        System.out.println("Bubble Sort Time : " + bubbleTime / 1_000_000 + " ms");
        System.out.println("Merge Sort Time  : " + mergeTime / 1_000_000 + " ms");
        System.out.println("Quick Sort Time  : " + quickTime / 1_000_000 + " ms");
    }

    // Generate random array
    static int[] generateArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    // ---------------- Bubble Sort (O(N^2)) ----------------
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ---------------- Merge Sort (O(N log N)) ----------------
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ---------------- Quick Sort (O(N log N)) ----------------
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
