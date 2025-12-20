import java.util.Scanner;

public class BodyMassIndexApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== BMI Check Program ===");

        System.out.print("Enter body weight (kg): ");
        double bodyWeight = input.nextDouble();

        System.out.print("Enter height (meters): ");
        double bodyHeight = input.nextDouble();

        // BMI formula
        double bmiValue = bodyWeight / (bodyHeight * bodyHeight);

        System.out.println("Your BMI value is: " + bmiValue);

        // BMI classification
        if (bmiValue < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmiValue < 25) {
            System.out.println("Category: Normal weight");
        } else {
            System.out.println("Category: Overweight");
        }

        
    }
}
