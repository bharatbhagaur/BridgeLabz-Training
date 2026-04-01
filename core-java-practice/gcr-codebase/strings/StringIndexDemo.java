import java.util.Scanner;

class StringIndexDemo {

    // method to generate exception
    static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // invalid index
    }

    // method to handle exception
    static void handleException(String text) {

        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String value = sc.next();

        // generate exception
        // generateException(value);

        // handle exception safely
        handleException(value);

        sc.close();
    }
}
