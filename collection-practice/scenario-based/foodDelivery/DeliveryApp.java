package foodDelivery;

import java.util.Scanner;

public class DeliveryApp {

    public static void main(String[] args) {

        DeliveryService service = new DeliveryService();
        Scanner sc = new Scanner(System.in);

        // Add some agents (sample data)
        service.addAgent(new Agent("A1", "Rahul", "9999999999", true));
        service.addAgent(new Agent("A2", "Aman", "8888888888", true));

        while (true) {

            System.out.println("\n1. Add Order");
            System.out.println("2. Assign Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. View Active Deliveries");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Enter orderId:");
                    String id = sc.nextLine();

                    System.out.println("Enter orderType:");
                    String type = sc.nextLine();

                    System.out.println("Enter orderQuantity:");
                    double qty = Double.parseDouble(sc.nextLine());

                    System.out.println("Enter paymentType:");
                    String pay = sc.nextLine();

                    service.addOrder(new Order(id, type, qty, pay));
                    System.out.println("Order added successfully ✅");
                    break;

                case 2:
                    try {
                        service.assignOrder();
                    } catch (NoAgentAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Enter orderId to cancel:");
                    String cancelId = sc.nextLine();
                    service.cancelOrder(cancelId);
                    break;

                case 4:
                    service.viewActiveDeliveries();
                    break;

                case 5:
                    System.out.println("Exiting app... 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice ❌");
            }
        }
    }
}

