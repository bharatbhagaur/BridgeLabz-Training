package lamdaexpression;

import java.util.*;
import java.util.stream.*;

public class InvoiceCreation {

    // Invoice class
    static class Invoice {
        int transactionId;

        // Constructor receives transaction ID
        Invoice(int transactionId) {
            this.transactionId = transactionId;
        }

        // Display invoice details
        public String toString() {
            return "Invoice created for Transaction ID " + transactionId;
        }
    }

    public static void main(String[] args) {

        // List of transaction IDs
        List<Integer> transactionIds =
                Arrays.asList(1001, 1002, 1003, 1004);

        // Creating invoice objects using constructor reference
        List<Invoice> invoices = transactionIds
                .stream()
                .map(Invoice::new)   // method reference
                .collect(Collectors.toList());

        // Print all invoices
        invoices.forEach(System.out::println);
    }
}
