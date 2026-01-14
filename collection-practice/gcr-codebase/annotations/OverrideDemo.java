// Parent class Animal
class Animal {

    // Method in parent class
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class Dog inherits Animal
class Dog extends Animal {


    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}


public class OverrideDemo {

    public static void main(String[] args) {

        // Create Dog object
        Dog dog = new Dog();

        // Call overridden method
        dog.makeSound();   // Output: Dog barks
    }
}
