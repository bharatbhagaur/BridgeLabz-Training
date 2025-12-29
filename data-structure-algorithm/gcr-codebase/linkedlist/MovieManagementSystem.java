// Import Scanner class for user input
import java.util.Scanner;

// ================= MOVIE NODE CLASS =================
class MovieNode {

    // Stores movie title
    String title;

    // Stores director name
    String director;

    // Stores year of release
    int year;

    // Stores movie rating
    double rating;

    // Pointer to next node
    MovieNode next;

    // Pointer to previous node
    MovieNode prev;

    // Constructor to initialize movie details
    MovieNode(String title, String director, int year, double rating) {

        // Assign movie title
        this.title = title;

        // Assign director
        this.director = director;

        // Assign year
        this.year = year;

        // Assign rating
        this.rating = rating;

        // Initialize next pointer as null
        this.next = null;

        // Initialize previous pointer as null
        this.prev = null;
    }
}

// ================= DOUBLY LINKED LIST CLASS =================
class MovieDoublyLinkedList {

    // Head pointer of the list
    MovieNode head;

    // Tail pointer of the list
    MovieNode tail;

    // -------- Add movie at beginning --------
    void addAtBeginning(String title, String director, int year, double rating) {

        // Create new movie node
        MovieNode newNode = new MovieNode(title, director, year, rating);

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

    // -------- Add movie at end --------
    void addAtEnd(String title, String director, int year, double rating) {

        // Create new movie node
        MovieNode newNode = new MovieNode(title, director, year, rating);

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

    // -------- Add movie at specific position --------
    void addAtPosition(int position, String title, String director, int year, double rating) {

        // If inserting at first position
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        // Create new movie node
        MovieNode newNode = new MovieNode(title, director, year, rating);

        // Temporary node for traversal
        MovieNode temp = head;

        // Traverse to (position - 1)
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If invalid position
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        // Adjust pointers
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // -------- Remove movie by title --------
    void removeByTitle(String title) {

        // If list is empty
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        // Temporary node
        MovieNode temp = head;

        // Search movie by title
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        // If movie not found
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        // If deleting head
        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
        }
        // If deleting tail
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // If deleting middle node
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie removed successfully.");
    }

    // -------- Search movie by director --------
    void searchByDirector(String director) {

        // Temporary node
        MovieNode temp = head;

        // Flag to check result
        boolean found = false;

        // Traverse list
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        // If no movie found
        if (!found)
            System.out.println("No movies found for this director.");
    }

    // -------- Search movie by rating --------
    void searchByRating(double rating) {

        // Temporary node
        MovieNode temp = head;

        // Flag
        boolean found = false;

        // Traverse list
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        // If no movie found
        if (!found)
            System.out.println("No movies found with this rating.");
    }

    // -------- Update movie rating --------
    void updateRating(String title, double newRating) {

        // Temporary node
        MovieNode temp = head;

        // Traverse list
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }

        // If movie not found
        System.out.println("Movie not found.");
    }

    // -------- Display movies forward --------
    void displayForward() {

        // Temporary node
        MovieNode temp = head;

        // If list empty
        if (temp == null) {
            System.out.println("No movies available.");
            return;
        }

        // Traverse from head to tail
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // -------- Display movies in reverse --------
    void displayReverse() {

        // Temporary node
        MovieNode temp = tail;

        // If list empty
        if (temp == null) {
            System.out.println("No movies available.");
            return;
        }

        // Traverse from tail to head
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // -------- Display single movie --------
    void displayMovie(MovieNode movie) {
        System.out.println("---------------------------------");
        System.out.println("Title    : " + movie.title);
        System.out.println("Director : " + movie.director);
        System.out.println("Year     : " + movie.year);
        System.out.println("Rating   : " + movie.rating);
    }
}

// ================= MAIN CLASS =================
public class MovieManagementSystem {

    public static void main(String[] args) {

        // Scanner object
        Scanner sc = new Scanner(System.in);

        // Create doubly linked list object
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        int choice;

        // Menu driven program
        do {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies Forward");
            System.out.println("9. Display Movies Reverse");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            // Read choice
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    list.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    list.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    list.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    list.removeByTitle(sc.next());
                    break;

                case 5:
                    list.searchByDirector(sc.next());
                    break;

                case 6:
                    list.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    list.updateRating(sc.next(), sc.nextDouble());
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 0:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        // Close scanner
        sc.close();
    }
}
