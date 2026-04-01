package functionalinterface;

interface UnitConverter {

    // Converts kilometers to miles
    static double convertKilometersToMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    // Converts kilograms to pounds
    static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }
}

public class UnitConversionApp {

    public static void main(String[] args) {

        double distanceInKm = 120.0;
        double weightInKg = 75.0;

        double miles = UnitConverter.convertKilometersToMiles(distanceInKm);
        double pounds = UnitConverter.convertKilogramsToPounds(weightInKg);

        System.out.println("Distance in miles: " + miles);
        System.out.println("Weight in pounds: " + pounds);
    }
}
