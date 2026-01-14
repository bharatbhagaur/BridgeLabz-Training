import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Scanner;

// --------------------
// Custom Annotation
// --------------------
@Retention(RetentionPolicy.RUNTIME)   // Needed for reflection
@interface RoleAllowed {
    String value();   // Required role
}


class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println(" User deleted successfully!");
    }

    @RoleAllowed("ADMIN")
    public void accessDashboard() {
        System.out.println(" Admin dashboard accessed!");
    }

    public void viewProfile() {
        System.out.println(" Profile viewed (Public Access)");
    }
}

// --------------------
// Security Manager (Validator)
// --------------------
class SecurityManager {

    // Validate access before method execution
    public static void executeMethod(Object obj, String methodName, String userRole) {

        try {
            Class<?> cls = obj.getClass();
            Method method = cls.getMethod(methodName);

            // Check if method has @RoleAllowed annotation
            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAllowed.value();

                // Role validation
                if (!requiredRole.equalsIgnoreCase(userRole)) {
                    System.out.println(" Access Denied! Required Role: " + requiredRole);
                    return;
                }
            }

            // Invoke method if allowed
            method.invoke(obj);
        }
        catch (NoSuchMethodException e) {
            System.out.println(" Method not found!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// --------------------
// Main Class
// --------------------
public class RoleBasedAccessDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AdminService service = new AdminService();

        // Simulate logged-in user role
        System.out.print("Enter your role (ADMIN / USER): ");
        String role = sc.next();

        // Simulate method access
        System.out.print("Enter method to execute (deleteUser / accessDashboard / viewProfile): ");
        String methodName = sc.next();

        // Execute with validation
        SecurityManager.executeMethod(service, methodName, role);

        sc.close();
    }
}
