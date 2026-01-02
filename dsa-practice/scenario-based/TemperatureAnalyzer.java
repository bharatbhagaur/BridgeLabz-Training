import java.util.Scanner;

public class TemperatureAnalyzer {

    // Method to analyze weekly temperature data
    public static void analyzeTemperature(float[][] temps) {

        int hottestDay = 0;
        int coldestDay = 0;

        // Initialize with first temperature value
        float maxTemp = temps[0][0];
        float minTemp = temps[0][0];

        // Loop through days
        for (int day = 0; day < 7; day++) {

            float dailySum = 0; // To calculate average temperature

            // Loop through hours
            for (int hour = 0; hour < 24; hour++) {

                float currentTemp = temps[day][hour];
                dailySum += currentTemp;

                // Check hottest temperature
                if (currentTemp > maxTemp) {
                    maxTemp = currentTemp;
                    hottestDay = day;
                }

                // Check coldest temperature
                if (currentTemp < minTemp) {
                    minTemp = currentTemp;
                    coldestDay = day;
                }
            }

            // Calculate and print daily average
            float average = dailySum / 24;
            System.out.println("Average temperature of Day " + (day + 1) + ": " + average);
        }

        // Final results
        System.out.println("\nHottest Day: Day " + (hottestDay + 1) + " with temperature " + maxTemp);
        System.out.println("Coldest Day: Day " + (coldestDay + 1) + " with temperature " + minTemp);
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare 2D array for 7 days and 24 hours
        float[][] weeklyTemps = new float[7][24];

        // Taking user input
        System.out.println("Enter temperature data for 7 days (24 hours each):");

        for (int day = 0; day < 7; day++) {
            System.out.println("Day " + (day + 1) + ":");

            for (int hour = 0; hour < 24; hour++) {
                System.out.print("  Hour " + (hour + 1) + ": ");
                weeklyTemps[day][hour] = sc.nextFloat();
            }
        }

        // Analyze temperature data
        analyzeTemperature(weeklyTemps);

        sc.close();
    }
}
