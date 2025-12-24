class LibraryBook {

    String bookName;
    String writer;
    double cost;

    // no-argument constructor
    LibraryBook() {
        bookName = "NA";
        writer = "Not Specified";
        cost = 0.0;
    }

    // constructor with parameters
    LibraryBook(String bookName, String writer, double cost) {
        this.bookName = bookName;
        this.writer = writer;
        this.cost = cost;
    }

    // prints book information
    void showInfo() {
        System.out.println("Title : " + bookName);
        System.out.println("Written By : " + writer);
        System.out.println("Book Price : " + cost);
    }
}

public class BookInfoApp {
    public static void main(String[] args) {

        // object using default constructor
        LibraryBook bookOne = new LibraryBook();

        // object using parameterized constructor
        LibraryBook bookTwo = new LibraryBook("Java Fundamentals", "James Gosling", 499.50);

        bookOne.showInfo();
        System.out.println("--------------------");
        bookTwo.showInfo();
    }
}
