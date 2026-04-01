// Import Stack class
import java.util.Stack;

// ================= QUEUE USING STACKS CLASS =================
class QueueUsingStacks {

    // Stack used for enqueue operation
    Stack<Integer> s1 = new Stack<>();

    // Stack used for dequeue operation
    Stack<Integer> s2 = new Stack<>();

    // -------- Enqueue operation --------
    void enqueue(int data) {

        // Push element into stack s1
        s1.push(data);

        // Confirmation message
        System.out.println(data + " enqueued into queue.");
    }

    // -------- Dequeue operation --------
    int dequeue() {

        // If both stacks are empty, queue is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        // If s2 is empty, transfer elements from s1 to s2
        if (s2.isEmpty()) {

            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Pop the top element from s2 (front of queue)
        return s2.pop();
    }

    // -------- Peek (Front element) --------
    int peek() {

        // If both stacks are empty
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        // If s2 is empty, transfer elements
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Return front element without removing
        return s2.peek();
    }

    // -------- Check if queue is empty --------
    boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // -------- Display queue --------
    void display() {

        // If queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");

        // First display elements from s2 (top to bottom)
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }

        // Then display elements from s1 (bottom to top)
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }
}

// ================= MAIN CLASS =================
public class QueueUsingTwoStacks {

    public static void main(String[] args) {

        // Create queue object
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display queue
        queue.display();

        // Dequeue element
        System.out.println("Dequeued: " + queue.dequeue());

        // Peek front element
        System.out.println("Front element: " + queue.peek());

        // Display queue again
        queue.display();
    }
}
