abstract class Shape {
    abstract double area();

    void describe() {
        System.out.println("Area: " + area());
    }
}


class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }
}

public class Main {
    public static void main(String[] args) {

    
        Shape namedSquare = new Square(5);

    
        Shape anonTriangle = new Shape() {
            @Override
            double area() {
                return 0.5 * 6 * 4;
            }
        };

        namedSquare.describe();
        anonTriangle.describe();

       
    }
}