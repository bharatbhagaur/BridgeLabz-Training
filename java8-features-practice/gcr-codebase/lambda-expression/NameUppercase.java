package lamdaexpression;

import java.util.*;
import java.util.stream.*;

public class NameUppercase {

    public static void main(String[] args) {

        // List of employee names
        List<String> names = Arrays.asList(
                "bharat", "rohit", "aman", "neha"
        );

        // Convert names to uppercase using method reference
        List<String> upperNames = names
                .stream()
                .map(String::toUpperCase)   // method reference
                .collect(Collectors.toList());

        // Print uppercase names
        upperNames.forEach(System.out::println);
    }
}
