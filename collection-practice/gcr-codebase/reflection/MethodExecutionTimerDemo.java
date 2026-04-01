import java.lang.reflect.Method;
import java.util.Scanner;

// Target Class (Methods to Measure)
class Calculator {

    public void add() {
        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        System.out.println("Add Completed");
    }

    public void multiply() {
        long result = 1;
        for (int i = 1; i < 100_000; i++) {
            result *= i;
            result %= 100000; // avoid overflow
        }
        System.out.println("Multiply Completed");
    }

    public void sleepTest() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sleep Completed");
    }
}

// Main Class
public class MethodExecutionTimerDemo {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Available methods: add, multiply, sleepTest");
            System.out.print("Enter method name to execute: ");
            String methodName = sc.next();

            // Create object dynamically
            Calculator obj = new Calculator();

            // Get Class reference
            Class<?> cls = obj.getClass();

            // Get method dynamically
            Method method = cls.getMethod(methodName);

            // Start time
            long startTime = System.nanoTime();

            // Invoke method dynamically
            method.invoke(obj);

            // End time
            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;

            System.out.println(" Execution Time = " + executionTime + " ns");

            sc.close();
        }
        catch (NoSuchMethodException e) {
            System.out.println(" Invalid method name!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
