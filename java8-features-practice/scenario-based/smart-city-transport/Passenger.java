package smartcitytransport;

import java.time.LocalDate;
import java.time.LocalTime;

class Passenger {
    private String name;
    private String route;
    private double fare;
    private LocalTime travelTime;
    
    public Passenger(String name, String route, double fare, LocalTime travelTime) {
        this.name = name;
        this.route = route;
        this.fare = fare;
        this.travelTime = travelTime;
    }
    
    public String getName() { return name; }
    public String getRoute() { return route; }
    public double getFare() { return fare; }
    public LocalTime getTravelTime() { return travelTime; }
    
    public boolean isPeakTime() {
        return (travelTime.isAfter(LocalTime.of(7, 0)) && travelTime.isBefore(LocalTime.of(10, 0))) ||
               (travelTime.isAfter(LocalTime.of(17, 0)) && travelTime.isBefore(LocalTime.of(20, 0)));
    }
}