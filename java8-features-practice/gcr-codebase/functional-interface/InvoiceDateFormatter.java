package functionalinterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateFormatterUtil {

    // Static method to format date in different patterns
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class InvoiceDateFormatter {

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        String formatOne = DateFormatterUtil.formatDate(invoiceDate, "dd-MM-yyyy");
        String formatTwo = DateFormatterUtil.formatDate(invoiceDate, "yyyy/MM/dd");
        String formatThree = DateFormatterUtil.formatDate(invoiceDate, "MMM dd, yyyy");

        System.out.println("Format 1: " + formatOne);
        System.out.println("Format 2: " + formatTwo);
        System.out.println("Format 3: " + formatThree);
    }
}

