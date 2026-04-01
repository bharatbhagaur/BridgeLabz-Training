import java.util.Scanner;

public class PrimeNumberChecker {

    // Method to check prime number
    static boolean isPrime(int number) {

        if (number <= 1)
            return false;

        // check divisibility
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int value = sc.nextInt();

        if (isPrime(value))
            System.out.println("Number is Prime");
        else
            System.out.println("Number is Not Prime");
    }
}
