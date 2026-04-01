import java.util.Scanner;

public class NumberSignChecker {

    // Method returns 1, -1 or 0
    static int checkNumber(int value) {
        if (value > 0)
            return 1;
        else if (value < 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int result = checkNumber(num);

        if (result == 1)
            System.out.println("Number is Positive");
        else if (result == -1)
            System.out.println("Number is Negative");
        else
            System.out.println("Number is Zero");
    }
}
