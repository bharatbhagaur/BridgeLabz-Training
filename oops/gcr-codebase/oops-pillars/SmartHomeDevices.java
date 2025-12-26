import java.util.*;

class Device {
    int deviceId;
    String status;

    // constructor for common device properties
    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // method to display basic device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    // constructor for thermostat-specific details
    Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // overridden method to show thermostat details
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        // creating a Thermostat object
        Thermostat t1 = new Thermostat(101, "ON", 24);

        // calling overridden method
        t1.displayStatus();
    }
}