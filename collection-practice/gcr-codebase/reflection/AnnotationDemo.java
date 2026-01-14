import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Annotation available at runtime
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}
@Author(name = "Bharat Don")
class Book {

    void display() {
        System.out.println("Book class running...");
    }
}

public class AnnotationDemo {

    public static void main(String[] args) {

        // Get Class object
        Class<Book> cls = Book.class;

        // Check if annotation exists
        if (cls.isAnnotationPresent(Author.class)) {

            // Get annotation
            Author author = cls.getAnnotation(Author.class);

            // Display annotation value
            System.out.println("Author Name = " + author.name());
        }
        else {
            System.out.println("Author annotation not found!");
        }
    }
}

