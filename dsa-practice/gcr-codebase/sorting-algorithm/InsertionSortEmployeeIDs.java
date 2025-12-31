public class InsertionSortEmployeeIDs {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array of employee IDs
        int[] empIDs = {1045, 1021, 1090, 1012, 1056};

        // Step 2: Store the length of the array
        int n = empIDs.length;

        // Step 3: Insertion Sort logic
        // Start from index 1 because index 0 is already considered sorted
        for (int i = 1; i < n; i++) {

            // Step 4: Store the current element to be inserted
            int key = empIDs[i];

            // Step 5: Compare with elements in the sorted part
            int j = i - 1;

            // Step 6: Shift elements greater than key to the right
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }

            // Step 7: Insert the key at its correct position
            empIDs[j + 1] = key;
        }

        // Step 8: Display sorted employee IDs
        System.out.println("Employee IDs in ascending order:");
        for (int id : empIDs) {
            System.out.print(id + " ");
        }
    }
}
