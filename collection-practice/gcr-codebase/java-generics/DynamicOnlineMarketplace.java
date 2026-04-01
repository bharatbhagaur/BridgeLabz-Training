import java.util.*;

// base interface for product categories
interface Category {
    String getCategoryName();
}

// category types
class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

// generic Product class restricted to Category types
class Product<T extends Category> {
    private String productName;
    private double price;
    private T category;

    // constructor to initialize product
    Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    String getProductName() {
        return productName;
    }

    T getCategory() {
        return category;
    }

    void displayProduct() {
        System.out.println("Product: " + productName);
        System.out.println("Category: " + category.getCategoryName());
        System.out.println("Price: " + price);
    }
}

public class DynamicOnlineMarketplace {

    // generic method to apply discount dynamically
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }

    public static void main(String[] args) {

        // creating products of different categories
        Product<BookCategory> book = new Product<>("Java Programming", 800, new BookCategory());

        Product<ClothingCategory> cloth = new Product<>("Jacket", 3000, new ClothingCategory());

        Product<GadgetCategory> gadget = new Product<>("Smart Watch", 12000, new GadgetCategory());

        // storing all products in a single catalog
        ArrayList<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(cloth);
        catalog.add(gadget);

        // applying discount using generic method
        applyDiscount(book, 10);
        applyDiscount(cloth, 20);
        applyDiscount(gadget, 5);

        // displaying catalog products
        for (Product<?> p : catalog) {
            p.displayProduct();
            System.out.println();
        }
    }
}
