import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name (example: java.util.ArrayList): ");
        String className = sc.nextLine();

        try {
            // Load class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\n================ CLASS INFORMATION ================");
            System.out.println("Class Name: " + cls.getName());

            // ---------- Constructors ----------
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }

            // ---------- Fields ----------
            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }

            // ---------- Methods ----------
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } catch (ClassNotFoundException e) {
            System.out.println(" Class not found! Please enter a valid class name.");
        }

        sc.close();
    }
}
