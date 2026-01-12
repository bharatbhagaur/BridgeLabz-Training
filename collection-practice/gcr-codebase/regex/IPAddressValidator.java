import java.util.Scanner;

public class IPAddressValidator {
    public static void main(String[] args) {

        // Take input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();

        
        String regex =
                "^((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]{1,2}))" +
                "(\\.((25[0-5])|(2[0-4][0-9])|([0-1]?[0-9]{1,2}))){3}$";

        // Validate IP using matches()
        if (ip.matches(regex)) {
            System.out.println("Valid IPv4 Address ");
        } else {
            System.out.println("Invalid IPv4 Address ");
        }

        sc.close();
    }
}
