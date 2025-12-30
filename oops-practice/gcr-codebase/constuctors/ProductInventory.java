import java.util.*;

class Product {
    // instance variables (unique for each object)
    String productName;
    double price;

    // class variable (shared among all objects)
    static int totalProducts = 0;

    // parameterized constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment when a new product is created
    }

    // instance method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    // class method to display total products
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}

public class ProductInventory {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mobile", 25000);
        Product p3 = new Product("Headphones", 2000);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();
        p3.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts(); // class method call
    }
}