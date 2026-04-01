import java.lang.reflect.Method;
import java.util.Scanner;
class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionCalculator {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            // User input
            System.out.print("Enter method name (add / subtract / multiply): ");
            String methodName = sc.next();

            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Create object
            MathOperations obj = new MathOperations();

            // Get Class object
            Class<?> cls = obj.getClass();

            // Get method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Invoke method dynamically
            Object result = method.invoke(obj, num1, num2);

            System.out.println("Result = " + result);

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
