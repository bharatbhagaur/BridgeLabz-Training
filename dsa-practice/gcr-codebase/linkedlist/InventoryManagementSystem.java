// Import Scanner class for user input
import java.util.Scanner;

// ================= ITEM NODE CLASS =================
class ItemNode {

    // Stores item name
    String itemName;

    // Stores unique item ID
    int itemId;

    // Stores quantity of item
    int quantity;

    // Stores price per unit
    double price;

    // Pointer to next node
    ItemNode next;

    // Constructor to initialize item details
    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;   // assign item name
        this.itemId = itemId;       // assign item ID
        this.quantity = quantity;   // assign quantity
        this.price = price;         // assign price
        this.next = null;           // next pointer initially null
    }
}

// ================= LINKED LIST CLASS =================
class InventoryLinkedList {

    // Head pointer of the list
    ItemNode head;

    // -------- Add item at beginning --------
    void addAtBeginning(String name, int id, int qty, double price) {

        // Create new node
        ItemNode newNode = new ItemNode(name, id, qty, price);

        // Point new node to head
        newNode.next = head;

        // Move head to new node
        head = newNode;
    }

    // -------- Add item at end --------
    void addAtEnd(String name, int id, int qty, double price) {

        // Create new node
        ItemNode newNode = new ItemNode(name, id, qty, price);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Temporary node for traversal
        ItemNode temp = head;

        // Traverse till last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node at end
        temp.next = newNode;
    }

    // -------- Add item at specific position --------
    void addAtPosition(int position, String name, int id, int qty, double price) {

        // If position is first
        if (position == 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }

        // Create new node
        ItemNode newNode = new ItemNode(name, id, qty, price);

        // Temporary node
        ItemNode temp = head;

        // Traverse to (position - 1)
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If invalid position
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        // Adjust pointers
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // -------- Remove item by Item ID --------
    void removeById(int id) {

        // If list empty
        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }

        // If head needs to be removed
        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        // Temporary node
        ItemNode temp = head;

        // Find node before target
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        // If item not found
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    // -------- Update quantity by Item ID --------
    void updateQuantity(int id, int newQty) {

        // Temporary node
        ItemNode temp = head;

        // Traverse list
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // -------- Search item by ID --------
    void searchById(int id) {

        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // -------- Search item by Name --------
    void searchByName(String name) {

        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }

    // -------- Calculate total inventory value --------
    void calculateTotalValue() {

        double total = 0.0;
        ItemNode temp = head;

        // Traverse list
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = ₹" + total);
    }

    // -------- Sort by Item Name --------
    void sortByName(boolean ascending) {

        // Bubble sort on linked list
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {

                // Compare names
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {

                    // Swap data
                    swapData(i, j);
                }
            }
        }
    }

    // -------- Sort by Price --------
    void sortByPrice(boolean ascending) {

        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {

                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {

                    // Swap data
                    swapData(i, j);
                }
            }
        }
    }

    // -------- Swap item data --------
    void swapData(ItemNode a, ItemNode b) {

        String tempName = a.itemName;
        int tempId = a.itemId;
        int tempQty = a.quantity;
        double tempPrice = a.price;

        a.itemName = b.itemName;
        a.itemId = b.itemId;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemId = tempId;
        b.quantity = tempQty;
        b.price = tempPrice;
    }

    // -------- Display all items --------
    void displayAll() {

        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }

        ItemNode temp = head;

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // -------- Display single item --------
    void displayItem(ItemNode item) {
        System.out.println("--------------------------------");
        System.out.println("Item Name : " + item.itemName);
        System.out.println("Item ID   : " + item.itemId);
        System.out.println("Quantity  : " + item.quantity);
        System.out.println("Price     : ₹" + item.price);
    }
}

// ================= MAIN CLASS =================
public class InventoryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();
        int choice;

        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    inventory.addAtBeginning(sc.next(), sc.nextInt(),
                            sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    inventory.addAtEnd(sc.next(), sc.nextInt(),
                            sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    inventory.addAtPosition(sc.nextInt(), sc.next(),
                            sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    inventory.removeById(sc.nextInt());
                    break;

                case 5:
                    inventory.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;

                case 6:
                    inventory.searchById(sc.nextInt());
                    break;

                case 7:
                    inventory.searchByName(sc.next());
                    break;

                case 8:
                    inventory.displayAll();
                    break;

                case 9:
                    inventory.calculateTotalValue();
                    break;

                case 10:
                    inventory.sortByName(true);
                    break;

                case 11:
                    inventory.sortByPrice(true);
                    break;

                case 0:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}

