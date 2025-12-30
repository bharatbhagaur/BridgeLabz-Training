import java.util.*; 

class Book {
    String title;
    String author;
    double price;

    // method to display book details
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b = new Book();

        System.out.print("Enter book title: ");
        b.title = sc.nextLine();

        System.out.print("Enter author name: ");
        b.author = sc.nextLine();

        System.out.print("Enter price: ");
        b.price = sc.nextDouble();

        b.displayDetails();

        sc.close();
    }
}