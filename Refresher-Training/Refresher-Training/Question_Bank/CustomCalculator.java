import java.util.*;

abstract class Calculator {

    abstract int add(int a, int b);
}

class Adder extends Calculator {

    @Override
    int add(int a, int b) {
        System.out.println("Adding: " + a + " " + b);
        return a + b;
    }
}

class Multiplier {

    private Adder adder;

    Multiplier() {
        adder = new Adder();
    }

    int multiply(int a, int b) {

        int result = 0;

        for (int i = 0; i < b; i++) {
            result = adder.add(result, a);
        }

        return result;
    }
}

public class CustomCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Adder adder = new Adder();

        System.out.println("Adding: " + a + " " + b);
        int sum = adder.add(a, b);

        System.out.println("Sum: " + sum);

        System.out.println("Multiplying: " + a + " " + b);

        Multiplier multiplier = new Multiplier();

        int product = multiplier.multiply(a, b);

        System.out.println("Product: " + product);

        sc.close();
    }
}