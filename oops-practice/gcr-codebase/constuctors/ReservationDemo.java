class RoomReservation {

    String customerName;
    String category;
    int stayDays;

    // no-argument constructor
    RoomReservation() {
        customerName = "Visitor";
        category = "Basic";
        stayDays = 1;
    }

    // constructor with parameters
    RoomReservation(String customerName, String category, int stayDays) {
        this.customerName = customerName;
        this.category = category;
        this.stayDays = stayDays;
    }

    // copy constructor
    RoomReservation(RoomReservation rr) {
        this.customerName = rr.customerName;
        this.category = rr.category;
        this.stayDays = rr.stayDays;
    }

    // method to show reservation info
    void showReservation() {
        System.out.println("Customer: " + customerName);
        System.out.println("Room Category: " + category);
        System.out.println("Number of Days: " + stayDays);
    }
}

public class ReservationDemo {
    public static void main(String[] args) {

        // using default constructor
        RoomReservation r1 = new RoomReservation();

        // using parameterized constructor
        RoomReservation r2 = new RoomReservation("Rahul", "Deluxe", 3);

        // using copy constructor
        RoomReservation r3 = new RoomReservation(r2);

        r1.showReservation();
        System.out.println("---------------");
        r2.showReservation();
        System.out.println("---------------");
        r3.showReservation();
    }
}
