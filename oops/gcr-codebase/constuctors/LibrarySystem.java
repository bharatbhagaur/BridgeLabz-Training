import java.util.*;

class Book {
    public String ISBN; // public: accessible everywhere
    protected String title; // protected: accessible in subclass
    private String author; // private: accessible only inside this class

    // constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // getter for author
    public String getAuthor() {
        return author;
    }
}

// subclass to demonstrate access modifiers
class EBook extends Book {

    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN); // public access
        System.out.println("Title: " + title); // protected access
        System.out.println("Author: " + getAuthor()); // private via getter
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        EBook eb = new EBook("978-0135166307", "Core Java", "Cay S. Horstmann");

        eb.displayEBookDetails();

        eb.setAuthor("Herbert Schildt");
        System.out.println("Updated Author: " + eb.getAuthor());
    }
}