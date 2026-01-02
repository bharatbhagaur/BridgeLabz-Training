import java.time.LocalDateTime;
import java.util.*;

// ===== Custom Exceptions =====
class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

class EmptyMessageException extends Exception {
    EmptyMessageException(String msg) {
        super(msg);
    }
}

// =====> CallLog Class 
class CallLog {
    String phone;
    String message;
    LocalDateTime time;

    CallLog(String phone, String message, LocalDateTime time) {
        this.phone = phone;
        this.message = message;
        this.time = time;
    }

    public String toString() {
        return phone + " | " + message + " | " + time;
    }
}

// ===== >Main Class 
public class CallLogApp {

    static List<CallLog> logs = new ArrayList<>();

    // Add call log method
    static void addCallLog(String phone, String message)
            throws InvalidPhoneNumberException, EmptyMessageException {

        if (!phone.matches("\\d{10}"))
            throw new InvalidPhoneNumberException("Invalid phone number");

        if (message.trim().isEmpty())
            throw new EmptyMessageException("Message cannot be empty");

        logs.add(new CallLog(phone, message, LocalDateTime.now()));
    }

    // Search by keyword
    static void searchByKeyword(String key) {
        for (CallLog log : logs) {
            if (log.message.toLowerCase().contains(key.toLowerCase())) {
                System.out.println(log);
            }
        }
    }

    // Filter by time
    static void filterByTime(int hours) {
        LocalDateTime start = LocalDateTime.now().minusHours(hours);

        for (CallLog log : logs) {
            if (!log.time.isBefore(start)) {
                System.out.println(log);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            addCallLog(phone, message);

            System.out.println("\nCall log added successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nEnter keyword to search: ");
        String key = sc.nextLine();
        searchByKeyword(key);

        System.out.print("\nShow logs of last how many hours? ");
        int hours = sc.nextInt();
        filterByTime(hours);

        
    }
}
