import java.util.*;

abstract class Car {

    // Concrete method
    public boolean getIsSedan() {
        return false;
    }

    // Concrete method
    public int getSeats() {
        return 4;
    }

    // Abstract method
    public abstract int getMileage();
}

class WagonR extends Car {

    @Override
    public int getMileage() {
        return 20;
    }
}

class HondaCity extends Car {

    @Override
    public boolean getIsSedan() {
        return true;
    }

    @Override
    public int getSeats() {
        return 5;
    }

    @Override
    public int getMileage() {
        return 15;
    }
}

class InnovaCrysta extends Car {

    @Override
    public int getSeats() {
        return 6;
    }

    @Override
    public int getMileage() {
        return 12;
    }
}

public class Question20 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        Car car;

        if (choice == 0) {
            car = new WagonR();
        }
        else if (choice == 1) {
            car = new HondaCity();
        }
        else {
            car = new InnovaCrysta();
        }

        System.out.println("Is Sedan: " + car.getIsSedan());
        System.out.println("Seats: " + car.getSeats());
        System.out.println("Mileage: " + car.getMileage());

        sc.close();
    }
}