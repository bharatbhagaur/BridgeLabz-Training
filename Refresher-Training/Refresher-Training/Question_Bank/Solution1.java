class Car {
    int speed;
    int numberOfTyres;

    Car(int speed, int numberOfTyres) {
        this.speed = speed;
        this.numberOfTyres = numberOfTyres;
    }

    void accelerate() {
        System.out.println("Car is accelerating");
    }

    void speed() {
        System.out.println("Car speed: " + speed + " km/h");
    }
}

class BMW extends Car {

    BMW(int speed, int numberOfTyres) {
        super(speed, numberOfTyres);
    }

    @Override
    void accelerate() {
        System.out.println("BMW is accelerating quickly");
    }

    @Override
    void speed() {
        System.out.println("BMW speed: " + speed + " km/h");
    }
}

public class Solution1 {
    public static void main(String[] args) {

        BMW bmw = new BMW(250, 4);

        bmw.accelerate();
        bmw.speed();

        System.out.println("Number of tyres: " + bmw.numberOfTyres);
    }
}