package smartcitytransport;



import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

interface TransportService {
    String getServiceType();
    double getFare(String from, String to);
    LocalDateTime getNextDeparture();
    String getRoute();
    
    default void printServiceDetails() {
        System.out.println("Service: " + getServiceType() + 
                         " | Next: " + getNextDeparture() + 
                         " | Route: " + getRoute());
    }
}