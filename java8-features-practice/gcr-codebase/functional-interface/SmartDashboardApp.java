package functionalinterface;

interface VehicleDashboard {

    void displaySpeed(int speed);

    // Default method added for electric vehicles
    default void displayBatteryStatus() {
        System.out.println("Battery status information not available for this vehicle");
    }
}

class PetrolCar implements VehicleDashboard {

    public void displaySpeed(int speed) {
        System.out.println("Current speed of petrol car: " + speed + " km/h");
    }
}

class ElectricCar implements VehicleDashboard {

    public void displaySpeed(int speed) {
        System.out.println("Current speed of electric car: " + speed + " km/h");
    }

    // Overriding default method for electric vehicle
    public void displayBatteryStatus() {
        System.out.println("Battery percentage: 78 percent");
    }
}

public class SmartDashboardApp {

    public static void main(String[] args) {

        VehicleDashboard petrolVehicle = new PetrolCar();
        VehicleDashboard electricVehicle = new ElectricCar();

        petrolVehicle.displaySpeed(65);
        petrolVehicle.displayBatteryStatus();

        electricVehicle.displaySpeed(80);
        electricVehicle.displayBatteryStatus();
    }
}
