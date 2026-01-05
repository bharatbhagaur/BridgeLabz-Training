import java.util.*;

public class ReverseQueue {

    // Method to reverse the queue using recursion
    static void reverseQueue(Queue<Integer> queue) {

        // Base case: empty queue
        if (queue.isEmpty()) {
            return;
        }

        // Step 1: Remove front element
        int front = queue.remove();

        // Step 2: Reverse remaining queue
        reverseQueue(queue);

        // Step 3: Add removed element to the rear
        queue.add(front);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        // Take number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Take queue elements
        System.out.println("Enter elements of queue:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        // Reverse the queue
        reverseQueue(queue);

        // Print reversed queue
        System.out.println("Reversed Queue: " + queue);

        sc.close();
    }
}
