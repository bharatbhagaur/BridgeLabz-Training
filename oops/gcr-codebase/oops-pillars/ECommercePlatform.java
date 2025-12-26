import java.util.*;

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    // constructor for common product details
    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // setters for encapsulation
    void setPrice(double price) {
        this.price = price;
    }

    double getPrice() {
        return price;
    }

    String getName() {
        return name;
    }

    // abstract method for discount
    abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {

    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

class Clothing extends Product implements Taxable {

    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.20;
    }

    public double calculateTax() {
        return getPrice() * 0.12;
    }

    public String getTaxDetails() {
        return "Clothing Tax: 12%";
    }
}

class Groceries extends Product {

    Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {

    // polymorphic method
    static void printFinalPrice(Product p) {
        double tax = 0;

        if (p instanceof Taxable) {
            tax = ((Taxable) p).calculateTax();
            System.out.println(((Taxable) p).getTaxDetails());
        }

        double finalPrice = p.getPrice() + tax - p.calculateDiscount();
        System.out.println("Product: " + p.getName());
        System.out.println("Final Price: " + finalPrice);
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice Bag", 1200));

        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}