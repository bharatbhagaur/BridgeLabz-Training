import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// --------------------
// Custom Annotation
// --------------------
@Retention(RetentionPolicy.RUNTIME)   // Available at runtime for reflection
@interface Todo {

    // Description of the task
    String task();

    // Developer responsible
    String assignedTo();

    // Default priority value
    String priority() default "MEDIUM";
}

// --------------------
// Class Using @Todo Annotation
// --------------------
class ProjectTasks {

    @Todo(
        task = "Implement user login",
        assignedTo = "Rahul",
        priority = "HIGH"
    )
    public void loginFeature() {
        System.out.println("Login feature code...");
    }

    @Todo(
        task = "Add payment gateway",
        assignedTo = "Amit"
    )   // priority will use default value MEDIUM
    public void paymentFeature() {
        System.out.println("Payment feature code...");
    }

    @Todo(
        task = "Improve dashboard UI",
        assignedTo = "Neha",
        priority = "LOW"
    )
    public void dashboardUI() {
        System.out.println("Dashboard UI code...");
    }
}

public class TodoAnnotationDemo {

    public static void main(String[] args) {

        // Get Class reference
        Class<ProjectTasks> cls = ProjectTasks.class;

        // Get all methods of the class
        Method[] methods = cls.getDeclaredMethods();

        System.out.println("📌 Pending Tasks List:\n");

        // Loop through all methods
        for (Method method : methods) {

            // Check if @Todo annotation is present
            if (method.isAnnotationPresent(Todo.class)) {

                // Retrieve annotation
                Todo todo = method.getAnnotation(Todo.class);

                // Print annotation values
                System.out.println("Method Name : " + method.getName());
                System.out.println("Task        : " + todo.task());
                System.out.println("Assigned To : " + todo.assignedTo());
                System.out.println("Priority    : " + todo.priority());
                System.out.println("--------------------------------");
            }
        }
    }
}

