import java.util.Scanner;

public class FibonacciGenerator {

    // Method to generate Fibonacci sequence
    static void generateFibonacci(int terms) {

        int first = 0;  // first term
        int second = 1; // second term

        System.out.print("Fibonacci Series: ");

        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");

            int next = first + second; // next term
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        generateFibonacci(n); // method call
    }
}

