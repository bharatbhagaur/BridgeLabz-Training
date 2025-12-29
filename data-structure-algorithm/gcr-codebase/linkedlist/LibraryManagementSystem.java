// Import Scanner class for user input
import java.util.Scanner;

// ================= BOOK NODE CLASS =================
class BookNode {

    // Stores book title
    String title;

    // Stores author name
    String author;

    // Stores genre
    String genre;

    // Stores unique book ID
    int bookId;

    // Stores availability status (Available / Issued)
    boolean isAvailable;

    // Pointer to next node
    BookNode next;

    // Pointer to previous node
    BookNode prev;

    // Constructor to initialize book details
    BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;             // assign title
        this.author = author;           // assign author
        this.genre = genre;             // assign genre
        this.bookId = bookId;           // assign book ID
        this.isAvailable = isAvailable; // assign availability
        this.next = null;               // next pointer initially null
        this.prev = null;               // prev pointer initially null
    }
}

// ================= DOUBLY LINKED LIST CLASS =================
class LibraryDoublyLinkedList {

    // Head pointer (first book)
    BookNode head;

    // Tail pointer (last book)
    BookNode tail;

    // -------- Add book at beginning --------
    void addAtBeginning(String title, String author, String genre, int id, boolean status) {

        // Create new book node
        BookNode newNode = new BookNode(title, author, genre, id, status);

        // If list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Attach new node before head
        newNode.next = head;
        head.prev = newNode;

        // Move head to new node
        head = newNode;
    }

    // -------- Add book at end --------
    void addAtEnd(String title, String author, String genre, int id, boolean status) {

        // Create new book node
        BookNode newNode = new BookNode(title, author, genre, id, status);

        // If list is empty
        if (tail == null) {
            head = tail = newNode;
            return;
        }

        // Attach new node after tail
        tail.next = newNode;
        newNode.prev = tail;

        // Move tail to new node
        tail = newNode;
    }

    // -------- Add book at specific position --------
    void addAtPosition(int position, String title, String author,
                       String genre, int id, boolean status) {

        // If inserting at first position
        if (position == 1) {
            addAtBeginning(title, author, genre, id, status);
            return;
        }

        // Create new node
        BookNode newNode = new BookNode(title, author, genre, id, status);

        // Temporary node
        BookNode temp = head;

        // Traverse to (position - 1)
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position invalid or inserting at end
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, status);
            return;
        }

        // Adjust pointers
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // -------- Remove book by Book ID --------
    void removeById(int id) {

        // If list is empty
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        // Temporary node
        BookNode temp = head;

        // Search book by ID
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        // If book not found
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        // If removing head
        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        }
        // If removing tail
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // If removing middle node
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed successfully.");
    }

    // -------- Search book by title --------
    void searchByTitle(String title) {

        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No book found with given title.");
    }

    // -------- Search book by author --------
    void searchByAuthor(String author) {

        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No book found for this author.");
    }

    // -------- Update availability status --------
    void updateAvailability(int id, boolean status) {

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // -------- Display books forward --------
    void displayForward() {

        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = head;

        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // -------- Display books reverse --------
    void displayReverse() {

        if (tail == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = tail;

        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // -------- Count total books --------
    void countBooks() {

        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total books in library: " + count);
    }

    // -------- Display single book --------
    void displayBook(BookNode book) {
        System.out.println("--------------------------------");
        System.out.println("Book ID     : " + book.bookId);
        System.out.println("Title       : " + book.title);
        System.out.println("Author      : " + book.author);
        System.out.println("Genre       : " + book.genre);
        System.out.println("Availability: " +
                (book.isAvailable ? "Available" : "Issued"));
    }
}

// ================= MAIN CLASS =================
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    library.addAtBeginning(sc.next(), sc.next(),
                            sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;

                case 2:
                    library.addAtEnd(sc.next(), sc.next(),
                            sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;

                case 3:
                    library.addAtPosition(sc.nextInt(), sc.next(),
                            sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;

                case 4:
                    library.removeById(sc.nextInt());
                    break;

                case 5:
                    library.searchByTitle(sc.next());
                    break;

                case 6:
                    library.searchByAuthor(sc.next());
                    break;

                case 7:
                    library.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    break;

                case 8:
                    library.displayForward();
                    break;

                case 9:
                    library.displayReverse();
                    break;

                case 10:
                    library.countBooks();
                    break;

                case 0:
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
