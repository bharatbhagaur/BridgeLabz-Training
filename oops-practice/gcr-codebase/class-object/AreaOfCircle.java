import java.util.*; 

class Circle {
    double radius;

    // method to calculate area of the circle
    double getArea() {
        return Math.PI * radius * radius;
    }

    // method to calculate circumference of the circle
    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // method to display results
    void display() {
        System.out.println("Area of Circle: " + getArea());
        System.out.println("Circumference of Circle: " + getCircumference());
    }
}

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c = new Circle();
        System.out.print("Enter radius: ");
        c.radius = sc.nextDouble();
        c.display();
        sc.close();
    }
}