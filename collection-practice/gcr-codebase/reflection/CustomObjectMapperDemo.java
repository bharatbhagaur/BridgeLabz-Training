import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Model Class
class Person {
    private int id;
    private String name;
    private double salary;

    public void display() {
        System.out.println("ID = " + id);
        System.out.println("Name = " + name);
        System.out.println("Salary = " + salary);
    }
}

// Object Mapper Utility
class ObjectMapperUtil {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {

        try {
            // Create object dynamically
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Set fields from map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {

                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                }
                catch (NoSuchFieldException e) {
                    System.out.println(" Field not found: " + fieldName);
                }
            }

            return obj;
        }
        catch (Exception e) {
            throw new RuntimeException("Object mapping failed", e);
        }
    }
}

// Main Class
public class CustomObjectMapperDemo {

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "Bharat Don");
        data.put("salary", 85000.75);

        Person p = ObjectMapperUtil.toObject(Person.class, data);

        p.display();
    }
}
