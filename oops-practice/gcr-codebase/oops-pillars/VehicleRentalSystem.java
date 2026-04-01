import java.util.*;

interface Insurable {
    // insurance amount calculation
    double calculateInsurance();

    // insurance information
    String getInsuranceDetails();
}

abstract class Vehicle {
    // sensitive details kept private
    private String vehicleNumber;
    private String type;

    // protected so subclasses can use it
    protected double rentalRate;

    // constructor for common vehicle data
    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    String getType() {
        return type;
    }

    // forces subclasses to implement their own logic
    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    // insurance policy number is encapsulated
    private String insurancePolicyNumber;

    Car(String vehicleNumber, double rate, String policyNo) {
        super(vehicleNumber, "Car", rate);
        this.insurancePolicyNumber = policyNo;
    }

    // rental calculation for car
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return rentalRate * 0.10;
    }

    public String getInsuranceDetails() {
        return "Car Insurance Applied";
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    Bike(String vehicleNumber, double rate, String policyNo) {
        super(vehicleNumber, "Bike", rate);
        this.insurancePolicyNumber = policyNo;
    }

    // rental calculation for bike
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return rentalRate * 0.05;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance Applied";
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    Truck(String vehicleNumber, double rate, String policyNo) {
        super(vehicleNumber, "Truck", rate);
        this.insurancePolicyNumber = policyNo;
    }

    // higher rental cost due to heavy usage
    double calculateRentalCost(int days) {
        return rentalRate * days * 1.2;
    }

    public double calculateInsurance() {
        return rentalRate * 0.15;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance Applied";
    }
}

public class VehicleRentalSystem {

    // polymorphic method to process any vehicle
    static void processRental(Vehicle v, int days) {
        double insurance = 0;

        // interface check before casting
        if (v instanceof Insurable) {
            insurance = ((Insurable) v).calculateInsurance();
            System.out.println(((Insurable) v).getInsuranceDetails());
        }

        System.out.println("Vehicle Type: " + v.getType());
        System.out.println("Rental Cost: " + v.calculateRentalCost(days));
        System.out.println("Insurance Cost: " + insurance);
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 1500, "C-INS-01"));
        vehicles.add(new Bike("BIKE202", 500, "B-INS-02"));
        vehicles.add(new Truck("TRUCK303", 3000, "T-INS-03"));

        // runtime polymorphism in action
        for (Vehicle v : vehicles) {
            processRental(v, 5);
        }
    }
}