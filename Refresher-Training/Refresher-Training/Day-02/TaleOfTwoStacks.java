import java.io.*;
import java.util.*;


public class TaleOfTwoStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (q-- > 0) {
            int type = sc.nextInt();

            switch (type) {
                case 1:
                    // Enqueue
                    int x = sc.nextInt();
                    stack1.push(x);
                    break;

                case 2:
                    // Dequeue
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    stack2.pop();
                    break;

                case 3:
                    // Print Front
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    System.out.println(stack2.peek());
                    break;
            }
        }

    
    }
}