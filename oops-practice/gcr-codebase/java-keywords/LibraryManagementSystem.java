import java.util.*;

class Book {
    // static variable shared across all books
    static String libraryName = "Central Library";

    String title;
    String author;
    final String isbn; // final: cannot be changed once assigned

    // constructor using this keyword
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // static method to display library name
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // instance method to display book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert C. Martin", "9780132350884");
        Book b2 = new Book("Effective Java", "Joshua Bloch", "9780134685991");

        Book.displayLibraryName();
        System.out.println();

        // instanceof check before displaying details
        if (b1 instanceof Book) {
            b1.displayDetails();
        }

        System.out.println();

        if (b2 instanceof Book) {
            b2.displayDetails();
        }
    }
}