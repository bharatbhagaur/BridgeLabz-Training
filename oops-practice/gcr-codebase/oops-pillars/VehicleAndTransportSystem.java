import java.util.*;

class Vehicle {
    int maxSpeed;
    String fuelType;

    // constructor to initialize common vehicle details
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // method to be overridden by subclasses
    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    // overridden method
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // overridden method
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    // overridden method
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Gear: " + hasGear);
    }
}

public class VehicleAndTransportSystem {
    public static void main(String[] args) {
        // polymorphism: Vehicle reference holding different subclass objects
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
