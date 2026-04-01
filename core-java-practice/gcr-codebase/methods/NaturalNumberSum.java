import java.util.Scanner;

public class NaturalNumberSum {

    // Recursive method
    static int recursiveSum(int n) {
        if (n == 0)
            return 0;
        return n + recursiveSum(n - 1);
    }

    // Formula method
    static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Not a Natural Number");
            return;
        }

        int recursionResult = recursiveSum(n);
        int formulaResult = formulaSum(n);

        System.out.println("Sum using recursion: " + recursionResult);
        System.out.println("Sum using formula: " + formulaResult);

        if (recursionResult == formulaResult)
            System.out.println("Both results are correct and equal");
        else
            System.out.println("Results do not match");
    }
}
