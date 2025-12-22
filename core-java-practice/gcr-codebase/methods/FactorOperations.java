import java.util.Scanner;

public class FactorOperations {

    // Method to find factors and return them as an array
    static int[] findFactors(int number) {

        // First loop: count factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }

        // Initialize array with factor count
        int[] factorList = new int[count];
        int index = 0;

        // Second loop: store factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                factorList[index++] = i;
        }

        return factorList;
    }

    // Method to calculate sum of factors
    static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int value : factors)
            sum += value;
        return sum;
    }

    // Method to calculate product of factors
    static long productOfFactors(int[] factors) {
        long product = 1;
        for (int value : factors)
            product *= value;
        return product;
    }

    // Method to calculate sum of squares of factors
    static double sumOfSquares(int[] factors) {
        double sum = 0;
        for (int value : factors)
            sum += Math.pow(value, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);

        System.out.println("Factors are:");
        for (int f : factors)
            System.out.print(f + " ");

        System.out.println("\nSum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    }
}
