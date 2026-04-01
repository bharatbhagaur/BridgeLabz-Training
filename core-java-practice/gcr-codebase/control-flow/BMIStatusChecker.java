import java.util.Scanner;

public class BMIStatusChecker {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight (kg): ");
        double mass = input.nextDouble();

        System.out.print("Enter your height (cm): ");
        double heightInCm = input.nextDouble();

        // Convert height to meters
        double heightInMeters = heightInCm * 0.01;

        // BMI formula
        double bmiValue = mass / Math.pow(heightInMeters, 2);

        System.out.println("Calculated BMI: " + bmiValue);

        // Determine BMI category
        String category;
        if (bmiValue < 18.5) {
            category = "Underweight";
        } else if (bmiValue < 25) {
            category = "Normal weight";
        } else if (bmiValue < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        System.out.println("Health Status: " + category);

        input.close();
    }
}

