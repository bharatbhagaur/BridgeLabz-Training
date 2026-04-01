import java.util.*;

class Animal {
    String name;
    int age;

    // constructor to initialize animal details
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // method to be overridden by subclasses
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    // overridden method
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    // overridden method
    void makeSound() {
        System.out.println("Cat meows");
    }
}

class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    // overridden method
    void makeSound() {
        System.out.println("Bird chirps");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        // polymorphism: parent reference, child object
        Animal a1 = new Dog("Buddy", 3);
        Animal a2 = new Cat("Whiskers", 2);
        Animal a3 = new Bird("Tweety", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}