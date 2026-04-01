import java.util.Scanner;

class LargestDigitCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = sc.nextInt();

        int limit = 10;
        int[] digits = new int[limit];
        int pos = 0;

        // Separating digits from number
        while (num != 0 && pos < limit) {
            digits[pos] = num % 10;   // taking last digit
            num = num / 10;           // removing last digit
            pos++;
        }

        int max = 0;
        int secondMax = 0;

        // Finding largest and second largest digit
        for (int i = 0; i < pos; i++) {
            if (digits[i] > max) {
                secondMax = max;
                max = digits[i];
            } else if (digits[i] > secondMax && digits[i] != max) {
                secondMax = digits[i];
            }
        }

        System.out.println("Largest digit is : " + max);
        System.out.println("Second largest digit is : " + secondMax);

        sc.close();
    }
}
