package smartcitytransport;



import java.time.LocalTime;
import java.time.LocalDateTime;

class BusService implements TransportService {
    private String route;
    private LocalDateTime nextDeparture;
    
    public BusService(String route, LocalDateTime nextDeparture) {
        this.route = route;
        this.nextDeparture = nextDeparture;
    }
    
    @Override
    public String getServiceType() { return "Bus"; }
    
    @Override
    public double getFare(String from, String to) {
        return GeoUtils.calculateDistance(from, to) * 0.5;
    }
    
    @Override
    public LocalDateTime getNextDeparture() { return nextDeparture; }
    
    @Override
    public String getRoute() { return route; }
}