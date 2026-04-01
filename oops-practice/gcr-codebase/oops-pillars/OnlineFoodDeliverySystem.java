import java.util.*;

interface Discountable {
    // calculate discount amount
    double applyDiscount();

    // discount information
    String getDiscountDetails();
}

abstract class FoodItem {
    // order details are encapsulated
    private String itemName;
    private double price;
    private int quantity;

    // constructor for common food item data
    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    String getItemName() {
        return itemName;
    }

    // forces subclasses to calculate their own total price
    abstract double calculateTotalPrice();

    // common item details
    void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {

    VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    // no extra charges for veg items
    double calculateTotalPrice() {
        return getPrice() * getQuantity() - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.10;
    }

    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {

    NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    // extra charge added for non-veg items
    double calculateTotalPrice() {
        return (getPrice() * getQuantity() + 50) - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.05;
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

public class OnlineFoodDeliverySystem {

    // polymorphic order processing
    static void processOrder(FoodItem item) {

        item.getItemDetails();

        if (item instanceof Discountable) {
            System.out.println(((Discountable) item).getDiscountDetails());
        }

        System.out.println("Total Price: " + item.calculateTotalPrice());
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));

        for (FoodItem item : order) {
            processOrder(item);
        }
    }
}