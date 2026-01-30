package streamapi;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDate;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}

public class GymMembership {
    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Ravi", LocalDate.now().plusDays(40)),
            new Member("Neha", LocalDate.now().plusDays(25)),
            new Member("Pooja", LocalDate.now().plusDays(5)),
            new Member("Karan", LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream()
               .filter(m -> !m.getExpiryDate().isBefore(today)
                         && !m.getExpiryDate().isAfter(next30Days))
               .forEach(m ->
                   System.out.println(m.getName()
                       + " → Expiry Date: " + m.getExpiryDate())
               );
    }
}
