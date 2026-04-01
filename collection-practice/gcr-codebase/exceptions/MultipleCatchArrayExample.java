import java.util.Scanner;

public class MultipleCatchArrayExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Ask array size
            System.out.print("Enter array size: ");
            int size = sc.nextInt();

            int[] arr = null;

            // If size > 0, initialize array
            if (size > 0) {
                arr = new int[size];

                // Take array elements
                System.out.println("Enter " + size + " elements:");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt();
                }
            }

            // Ask for index
            System.out.print("Enter index to retrieve value: ");
            int index = sc.nextInt();

            // Access array element
            int value = arr[index];

            System.out.println("Value at index " + index + ": " + value);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        finally {
            sc.close();
        }
    }
}
