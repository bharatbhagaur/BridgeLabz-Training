package functionalinterface;

import java.util.function.Predicate;

public class TemperatureMonitoringSystem {

    public static void main(String[] args) {

        double maximumAllowedTemperature = 68.0;

        // Predicate functional interface
        Predicate<Double> temperatureChecker = temperatureValue -> {
            return temperatureValue > maximumAllowedTemperature;
        };

        double firstReading = 61.4;
        double secondReading = 75.9;

        validateTemperature(firstReading, temperatureChecker);
        validateTemperature(secondReading, temperatureChecker);
    }

    private static void validateTemperature(double reading,
                                             Predicate<Double> condition) {

        boolean exceededLimit = condition.test(reading);

        if (exceededLimit) {
            System.out.println("Temperature limit exceeded. Current value: " + reading);
        } else {
            System.out.println("Temperature is within safe range. Current value: " + reading);
        }
    }
}

