package lamdaexpression;

import java.util.*;

public class EcommerceSorting {

    // Product class represents one product in shop
    static class Product {
        String name;
        double price;
        double rating;
        double discount;

        // Constructor to initialize product values
        Product(String name, double price, double rating, double discount) {
            this.name = name;
            this.price = price;
            this.rating = rating;
            this.discount = discount;
        }

        // This method is used to print product details
        public String toString() {
            return name + "  Price:" + price +
                   "  Rating:" + rating +
                   "  Discount:" + discount + "%";
        }
    }

    public static void main(String[] args) {

        // Creating product list
        List<Product> products = new ArrayList<>();

        // Adding products into list
        products.add(new Product("Laptop", 65000, 4.6, 10));
        products.add(new Product("Phone", 30000, 4.2, 20));
        products.add(new Product("Headphones", 2500, 4.8, 15));
        products.add(new Product("SmartWatch", 12000, 4.1, 25));

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Display menu options
        System.out.println("Choose sorting option");
        System.out.println("1 Price");
        System.out.println("2 Rating");
        System.out.println("3 Discount");

        // Read user choice
        int choice = sc.nextInt();

        // Comparator reference for sorting logic
        Comparator<Product> comparator;

        // Select sorting logic using lambda expression
        switch (choice) {

            // Sort by price in ascending order
            case 1:
                comparator = (p1, p2) ->
                        Double.compare(p1.price, p2.price);
                break;

            // Sort by rating in descending order
            case 2:
                comparator = (p1, p2) ->
                        Double.compare(p2.rating, p1.rating);
                break;

            // Sort by discount in descending order
            case 3:
                comparator = (p1, p2) ->
                        Double.compare(p2.discount, p1.discount);
                break;

            // If user enters wrong choice
            default:
                System.out.println("Invalid choice");
                return;
        }

        // Sorting the list using selected comparator
        Collections.sort(products, comparator);

        // Display sorted product list
        System.out.println("Sorted Products");
        for (Product p : products) {
            System.out.println(p);
        }

        // Close scanner
        sc.close();
    }
}
