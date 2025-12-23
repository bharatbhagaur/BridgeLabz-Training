import java.util.Scanner;

public class MaximumOfThree {

    // Method to find maximum of three numbers
    static int findMaximum(int a, int b, int c) {

        int max = a; // assume first number is max

        if (b > max)
            max = b;
v 
        if (c > max)
            max = c;

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking inputs
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        // method call
        int result = findMaximum(num1, num2, num3);

        System.out.println("Maximum number is: " + result);
    }
}
