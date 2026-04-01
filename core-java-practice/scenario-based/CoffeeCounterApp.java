import java.util.Scanner;

public class CoffeeCounterApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Coffee Counter ☕");

        while (true) {
            System.out.println("\nChoose your coffee:");
            System.out.println("1. Espresso");
            System.out.println("2. Latte");
            System.out.println("3. Cappuccino");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int option = input.nextInt();

            if (option == 4) {
                System.out.println("Thanks for visiting! Have a great day 😊");
                break;
            }

            System.out.print("Enter quantity: ");
            int qty = input.nextInt();

            double unitPrice;
            String coffeeName;

            switch (option) {
                case 1:
                    unitPrice = 100;
                    coffeeName = "Espresso";
                    break;
                case 2:
                    unitPrice = 120;
                    coffeeName = "Latte";
                    break;
                case 3:
                    unitPrice = 130;
                    coffeeName = "Cappuccino";
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
                    continue;
            }

            double billAmount = unitPrice * qty;

            System.out.println("\n----- BILL SUMMARY -----");
            System.out.println("Coffee Type : " + coffeeName);
            System.out.println("Quantity    : " + qty);
            System.out.println("Total Cost  : ₹" + billAmount);
        }

        
    }
}
