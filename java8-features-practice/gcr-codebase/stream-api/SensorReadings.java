package streamapi;

import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {

        List<Double> readings = Arrays.asList(
            22.5, 30.1, 28.0, 35.6, 18.9, 40.2
        );

        double threshold = 30.0;

        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r ->
                    System.out.println("High Sensor Reading: " + r)
                );
    }
}

