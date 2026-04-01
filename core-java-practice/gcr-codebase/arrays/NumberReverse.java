import java.util.Scanner;

class NumberReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any number: ");
        int value = sc.nextInt();

        int copy = value;
        int digitCount = 0;

        // counting total digits
        while (copy > 0) {
            digitCount++;
            copy = copy / 10;
        }

        int[] numArr = new int[digitCount];
        int[] revArr = new int[digitCount];

        copy = value;

        // storing digits into array
        for (int i = 0; i < digitCount; i++) {
            numArr[i] = copy % 10;
            copy = copy / 10;
        }

        // reversing the array
        for (int i = 0; i < digitCount; i++) {
            revArr[i] = numArr[digitCount - i - 1];
        }

        System.out.print("Reverse number is: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(revArr[i]);
        }

        sc.close();
    }
}
