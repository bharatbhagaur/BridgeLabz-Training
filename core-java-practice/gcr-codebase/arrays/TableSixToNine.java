import java.util.Scanner;

class TableSixToNine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Array to store multiplication results
        int[] multiplicationResult = new int[4];

        // Calculating multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Displaying result
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        sc.close();
    }
}
