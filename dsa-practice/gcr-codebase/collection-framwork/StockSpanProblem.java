// Import Stack class
import java.util.Stack;

public class StockSpanProblem {

    // -------- Method to calculate stock span --------
    static void calculateSpan(int[] price, int n, int[] span) {

        // Stack to store indices of days
        Stack<Integer> stack = new Stack<>();

        // First day's span is always 1
        span[0] = 1;

        // Push index of first day
        stack.push(0);

        // Loop for remaining days
        for (int i = 1; i < n; i++) {

            // Pop indices while current price is higher
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack becomes empty
            // span = i + 1 (all previous days smaller)
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current day index
            stack.push(i);
        }
    }

    // -------- Main method --------
    public static void main(String[] args) {

        // Stock prices array
        int[] price = {100, 80, 60, 70, 60, 75, 85};

        int n = price.length;

        // Span array
        int[] span = new int[n];

        // Calculate stock span
        calculateSpan(price, n, span);

        // Print results
        System.out.println("Stock Prices:");
        for (int p : price) {
            System.out.print(p + " ");
        }

        System.out.println("\nStock Spans:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
