public class BubbleSortStudentMarks {

    public static void main(String[] args) {

        // Step 1: Declare and initialize the array of student marks
        int[] marks = {78, 45, 90, 62, 88, 50};

        // Step 2: Store the length of the array
        int n = marks.length;

        // Step 3: Bubble Sort logic
        // Outer loop controls the number of passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop compares adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {

                // Step 4: Compare adjacent elements
                if (marks[j] > marks[j + 1]) {

                    // Step 5: Swap if elements are in wrong order
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }

        // Step 6: Display sorted student marks
        System.out.println("Student marks in ascending order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
