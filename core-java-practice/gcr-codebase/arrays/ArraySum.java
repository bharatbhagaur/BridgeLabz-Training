import java.util.Scanner;

class ArraySum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        // Taking input using infinite loop
        while (true) {
            System.out.print("Enter a number: ");
            double num = sc.nextDouble();

            if (num <= 0 || index == 10) {
                break;
            }

            values[index] = num;
            index++;
        }

        // Calculating sum
        for (int i = 0; i < index; i++) {
            System.out.println("Value: " + values[i]);
            total += values[i];
        }

        System.out.println("Total sum is: " + total);

        sc.close();
    }
}
