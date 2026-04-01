import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;


// Custom Annotation
// --------------------
@Retention(RetentionPolicy.RUNTIME)   // Needed for reflection
@interface MaxLength {

    // Maximum allowed length
    int value();
}


class User {

    // Apply annotation to field
    @MaxLength(10)
    private String username;

    // Constructor
    public User(String username) {

        // Validate length using reflection
        validateMaxLength(username);

        this.username = username;
        System.out.println("✅ User created successfully!");
    }

    // Validation Method
    private void validateMaxLength(String value) {
        try {
            // Get Field object of username
            Field field = this.getClass().getDeclaredField("username");

            // Check if @MaxLength annotation exists
            if (field.isAnnotationPresent(MaxLength.class)) {

                // Read annotation value
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                int limit = maxLength.value();

                // Validate length
                if (value.length() > limit) {
                    throw new IllegalArgumentException(
                        "❌ Username length exceeds limit! Max allowed = " + limit
                    );
                }
            }
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}


public class MaxLengthDemo {

    public static void main(String[] args) {

        // Valid case
        User u1 = new User("Bharat");   // OK

        // Invalid case (length > 10)
        User u2 = new User("VeryLongUsername123");  // Exception
    }
}
