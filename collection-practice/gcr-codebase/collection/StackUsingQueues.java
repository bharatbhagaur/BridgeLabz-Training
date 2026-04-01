import java.util.*;

public class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        // Step 1: Add element to empty helper queue
        q2.add(x);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Remove and return top element
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    // Return top element without removing
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // ---------------- Demo ----------------
    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        // Push operations
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop operation
        System.out.println("Pop: " + stack.pop()); // Output: 3

        // Top operation
        System.out.println("Top: " + stack.top()); // Output: 2
    }
}
