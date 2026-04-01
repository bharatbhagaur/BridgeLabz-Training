import java.util.*;
// abstract base class for all warehouse items
abstract class WarehouseItem {
    String itemName;

    WarehouseItem(String itemName) {
        this.itemName = itemName;
    }

    // each item provides its own details
    abstract void displayItem();
}

class Electronics extends WarehouseItem {

    Electronics(String itemName) {
        super(itemName);
    }

    void displayItem() {
        System.out.println("Electronics Item: " + itemName);
    }
}

class Groceries extends WarehouseItem {

    Groceries(String itemName) {
        super(itemName);
    }

    void displayItem() {
        System.out.println("Grocery Item: " + itemName);
    }
}

class Furniture extends WarehouseItem {

    Furniture(String itemName) {
        super(itemName);
    }

    void displayItem() {
        System.out.println("Furniture Item: " + itemName);
    }
}

// generic storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    // add item to storage
    void addItem(T item) {
        items.add(item);
    }

    // get all stored items
    List<T> getItems() {
        return items;
    }
}

public class SmartWarehouseManagementSystem {

    // wildcard method to display any warehouse items
    static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayItem();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // storage for electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        // storage for groceries
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Wheat"));

        // storage for furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chair"));

        // wildcard method works for all item types
        displayAllItems(electronicsStorage.getItems());
        displayAllItems(groceriesStorage.getItems());
        displayAllItems(furnitureStorage.getItems());
    }
}