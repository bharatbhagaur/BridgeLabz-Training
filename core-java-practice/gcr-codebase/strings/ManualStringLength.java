import java.util.Scanner;

class ManualStringLength {

    // method to calculate string size without using length()
    static int calculateSize(String str) {

        int size = 0;

        try {
            for (;;) {                 // infinite loop
                str.charAt(size);      // accessing character
                size++;
            }
        } catch (Exception ex) {
            // loop stops when index goes out of range
        }

        return size;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter any text: ");
        String text = input.next();

        int userLen = calculateSize(text);
        int systemLen = text.length();

        System.out.println("Length found by logic: " + userLen);
        System.out.println("Length using built-in: " + systemLen);

        
    }
}
