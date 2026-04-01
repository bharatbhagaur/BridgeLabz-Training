import java.util.Scanner;

public class AbundantNumberCheck {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int n = input.nextInt();

        int divisorSum = 0;

        // Find sum of all proper divisors
        for (int d = 1; d < n; d++) {
            if (n % d == 0) {
                divisorSum += d;
            }
        }

        // Abundant number condition
        if (divisorSum > n) {
            System.out.println(n + " is an Abundant Number");
        } else {
            System.out.println(n + " is NOT an Abundant Number");
        }

    
    }
}

