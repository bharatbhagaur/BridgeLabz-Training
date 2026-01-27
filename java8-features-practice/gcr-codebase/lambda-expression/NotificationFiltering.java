package lamdaexpression;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class NotificationFiltering {

    // Alert class
    static class Alert {
        String message;
        String type;   // emergency, appointment, report

        Alert(String message, String type) {
            this.message = message;
            this.type = type;
        }

        public String toString() {
            return type + " alert: " + message;
        }
    }

    public static void main(String[] args) {

        // List of alerts
        List<Alert> alerts = Arrays.asList(
                new Alert("Patient needs immediate help", "emergency"),
                new Alert("Doctor appointment reminder", "appointment"),
                new Alert("Lab report ready", "report"),
                new Alert("Emergency ward update", "emergency")
        );

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter alert type to view");
        System.out.println("emergency");
        System.out.println("appointment");
        System.out.println("report");

        String userChoice = sc.next();

        // Predicate using lambda
        Predicate<Alert> filterAlert =
                alert -> alert.type.equalsIgnoreCase(userChoice);

        // Filter alerts using predicate
        List<Alert> filteredAlerts = alerts
                .stream()
                .filter(filterAlert)
                .collect(Collectors.toList());

        // Display filtered alerts
        System.out.println("Filtered Alerts");
        filteredAlerts.forEach(System.out::println);

        sc.close();
    }
}
