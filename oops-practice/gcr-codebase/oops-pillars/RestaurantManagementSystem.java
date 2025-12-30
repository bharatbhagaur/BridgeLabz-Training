import java.util.*;

interface Worker {
    // method that must be implemented by working staff
    void performDuties();
}

class Person {
    String name;
    int id;

    // constructor for common person details
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {

    // constructor for Chef
    Chef(String name, int id) {
        super(name, id);
    }

    // chef-specific duties
    public void performDuties() {
        System.out.println("Chef is preparing food in the kitchen");
    }
}

class Waiter extends Person implements Worker {

    // constructor for Waiter
    Waiter(String name, int id) {
        super(name, id);
    }

    // waiter-specific duties
    public void performDuties() {
        System.out.println("Waiter is serving food to customers");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {

        Chef c = new Chef("Amit", 101);
        Waiter w = new Waiter("Rohit", 201);

        // calling interface method
        c.performDuties();
        w.performDuties();
    }
}