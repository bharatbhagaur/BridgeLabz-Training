package aerovigil;

public class FlightUtil {

    // Validate Flight Number
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {

        // Pattern: FL-XXXX where XXXX is between 1000 and 9999
        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    // Validate Flight Name
    public boolean validateFlightName(String flightName) throws InvalidFlightException {

        if (!(flightName.equalsIgnoreCase("SpiceJet") ||
              flightName.equalsIgnoreCase("Vistara") ||
              flightName.equalsIgnoreCase("IndiGo") ||
              flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException(
                    "The flight name " + flightName + " is invalid");
        }
        return true;
    }

    // Validate Passenger Count
    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int maxCapacity = 0;

        if (flightName.equalsIgnoreCase("SpiceJet"))
            maxCapacity = 396;
        else if (flightName.equalsIgnoreCase("Vistara"))
            maxCapacity = 615;
        else if (flightName.equalsIgnoreCase("IndiGo"))
            maxCapacity = 230;
        else if (flightName.equalsIgnoreCase("Air Arabia"))
            maxCapacity = 130;

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount +
                    " is invalid for " + flightName);
        }
        return true;
    }

    // Calculate Fuel
    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double maxFuelCapacity = 0;

        if (flightName.equalsIgnoreCase("SpiceJet"))
            maxFuelCapacity = 200000;
        else if (flightName.equalsIgnoreCase("Vistara"))
            maxFuelCapacity = 300000;
        else if (flightName.equalsIgnoreCase("IndiGo"))
            maxFuelCapacity = 250000;
        else if (flightName.equalsIgnoreCase("Air Arabia"))
            maxFuelCapacity = 150000;

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuelCapacity) {
            throw new InvalidFlightException(
                    "Invalid fuel level for " + flightName);
        }

        return maxFuelCapacity - currentFuelLevel;
    }
}
