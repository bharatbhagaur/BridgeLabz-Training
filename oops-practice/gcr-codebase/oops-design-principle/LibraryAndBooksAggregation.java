import java.util.*;

class Book {
    String title;
    String author;

    // constructor to initialize book details
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // method to display book information
    void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String libraryName;
    ArrayList<Book> books; // aggregation: Library has Book objects

    // constructor to initialize library
    Library(String libraryName) {
        this.libraryName = libraryName;
        books = new ArrayList<>();
    }

    // method to add a book to the library
    void addBook(Book b) {
        books.add(b);
    }

    // method to display all books in the library
    void displayLibraryBooks() {
        System.out.println("Library: " + libraryName);
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class LibraryAndBooksAggregation {
    public static void main(String[] args) {
        // Book objects can exist independently
        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Book b2 = new Book("Effective Java", "Joshua Bloch");
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");

        // creating Library objects
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("College Library");

        // adding books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // same book added to another library
        lib2.addBook(b3);

        lib1.displayLibraryBooks();
        System.out.println();
        lib2.displayLibraryBooks();
    }
}