import java.util.*;

class Circle {
    double radius;

    // default constructor
    Circle() {
        this(1.0); // calls parameterized constructor
    }

    // parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // method to calculate area
    double getArea() {
        return Math.PI * radius * radius;
    }

    // method to display details
    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }
}

public class CircleArea {
    public static void main(String[] args) {
        Circle c1 = new Circle(); // default radius
        Circle c2 = new Circle(5.0); // user-provided radius

        c1.display();
        System.out.println();
        c2.display();
    }
}