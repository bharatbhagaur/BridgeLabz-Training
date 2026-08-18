import java.util.Scanner;

class InvalidFlightException extends Exception {

    public InvalidFlightException(String message) {
        super(message);
    }
}

class FlightUtil {

    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (flightNumber == null ||
            !flightNumber.matches("FL-[0-9]{4}")) {

            throw new InvalidFlightException(
                "The flight number " + flightNumber + " is invalid"
            );
        }

        return true;
    }

    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        if (flightName == null ||
            !(flightName.equalsIgnoreCase("SpiceJet") ||
              flightName.equalsIgnoreCase("Vistara") ||
              flightName.equalsIgnoreCase("IndiGo") ||
              flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException(
                "The flight name " + flightName + " is invalid"
            );
        }

        return true;
    }

    public boolean validatePassengerCount(int passengerCount,
                                          String flightName)
            throws InvalidFlightException {

        int maxCapacity = 0;

        if (flightName.equalsIgnoreCase("SpiceJet")) {
            maxCapacity = 396;
        } else if (flightName.equalsIgnoreCase("Vistara")) {
            maxCapacity = 615;
        } else if (flightName.equalsIgnoreCase("IndiGo")) {
            maxCapacity = 230;
        } else if (flightName.equalsIgnoreCase("Air Arabia")) {
            maxCapacity = 130;
        }

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                "The passenger count " + passengerCount +
                " is invalid for " + flightName
            );
        }

        return true;
    }

    public double calculateFuelToFillTank(String flightName,
                                           double currentFuelLevel)
            throws InvalidFlightException {

        double capacity = 0;

        if (flightName.equalsIgnoreCase("SpiceJet")) {
            capacity = 200000;
        } else if (flightName.equalsIgnoreCase("Vistara")) {
            capacity = 300000;
        } else if (flightName.equalsIgnoreCase("IndiGo")) {
            capacity = 250000;
        } else if (flightName.equalsIgnoreCase("Air Arabia")) {
            capacity = 150000;
        }

        if (currentFuelLevel < 0 ||
            currentFuelLevel > capacity) {

            throw new InvalidFlightException(
                "Invalid fuel level for " + flightName
            );
        }

        return capacity - currentFuelLevel;
    }
}

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter flight details");

        String input = sc.nextLine();

        String[] data = input.split(":");

        String flightNumber = data[0];
        String flightName = data[1];
        int passengerCount = Integer.parseInt(data[2]);
        double currentFuelLevel = Double.parseDouble(data[3]);

        FlightUtil flightUtil = new FlightUtil();

        try {

            flightUtil.validateFlightNumber(flightNumber);

            flightUtil.validateFlightName(flightName);

            flightUtil.validatePassengerCount(
                passengerCount, flightName
            );

            double fuelRequired =
                flightUtil.calculateFuelToFillTank(
                    flightName, currentFuelLevel
                );

            System.out.println(
                "Fuel required to fill the tank: "
                + fuelRequired + " liters"
            );

        } catch (InvalidFlightException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        sc.close();
    }
}