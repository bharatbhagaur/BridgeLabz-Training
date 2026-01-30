package streamapi;

import java.util.*;

public class CustomerNames {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
            "ravi", "amit", "neha", "pooja", "karan"
        );

        names.stream()
             .map(String::toUpperCase)   // convert to uppercase
             .sorted()                  // alphabetical order
             .forEach(System.out::println);
    }
}

