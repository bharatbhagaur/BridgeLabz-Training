// Import Stack class
import java.util.Stack;

// ================= SORT STACK CLASS =================
class SortStack {

    // -------- Method to sort the stack --------
    static void sortStack(Stack<Integer> stack) {

        // Base case: if stack is empty
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop top element
        int top = stack.pop();

        // Step 2: Recursively sort remaining stack
        sortStack(stack);

        // Step 3: Insert popped element in sorted order
        insertSorted(stack, top);
    }

    // -------- Insert element in sorted position --------
    static void insertSorted(Stack<Integer> stack, int element) {

        // Base case:
        // If stack is empty OR element is greater than top
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Pop top element
        int top = stack.pop();

        // Recursively find correct position
        insertSorted(stack, element);

        // Push popped element back
        stack.push(top);
    }

    // -------- Display stack --------
    static void display(Stack<Integer> stack) {

        System.out.println("Stack elements (bottom → top):");

        // Display elements
        for (int element : stack) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// ================= MAIN CLASS =================
public class SortStackUsingRecursion {

    public static void main(String[] args) {

        // Create stack
        Stack<Integer> stack = new Stack<>();

        // Push elements into stack
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        // Display original stack
        System.out.println("Original Stack:");
        SortStack.display(stack);

        // Sort stack
        SortStack.sortStack(stack);

        // Display sorted stack
        System.out.println("Sorted Stack (Ascending Order):");
        SortStack.display(stack);
    }
}
