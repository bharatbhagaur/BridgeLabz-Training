// Import Scanner class for taking user input
import java.util.Scanner;

// ================= NODE CLASS =================
class StudentNode {

    // Stores roll number of student
    int rollNumber;

    // Stores name of student
    String name;

    // Stores age of student
    int age;

    // Stores grade of student
    String grade;

    // Reference to next node in linked list
    StudentNode next;

    // Constructor to initialize student data
    StudentNode(int rollNumber, String name, int age, String grade) {

        // Assign roll number
        this.rollNumber = rollNumber;

        // Assign name
        this.name = name;

        // Assign age
        this.age = age;

        // Assign grade
        this.grade = grade;

        // Initially next is null
        this.next = null;
    }
}

// ================= LINKED LIST CLASS =================
class StudentLinkedList {

    // Head pointer of the linked list
    StudentNode head;

    // -------- Add student at beginning --------
    void addAtBeginning(int roll, String name, int age, String grade) {

        // Create new node
        StudentNode newNode = new StudentNode(roll, name, age, grade);

        // Point new node to current head
        newNode.next = head;

        // Move head to new node
        head = newNode;

        // Confirmation message
        System.out.println("Student added at beginning.");
    }

    // -------- Add student at end --------
    void addAtEnd(int roll, String name, int age, String grade) {

        // Create new node
        StudentNode newNode = new StudentNode(roll, name, age, grade);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Temporary node to traverse list
        StudentNode temp = head;

        // Traverse till last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node at the end
        temp.next = newNode;

        // Confirmation message
        System.out.println("Student added at end.");
    }

    // -------- Add student at specific position --------
    void addAtPosition(int position, int roll, String name, int age, String grade) {

        // If position is first
        if (position == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        // Create new node
        StudentNode newNode = new StudentNode(roll, name, age, grade);

        // Temporary node for traversal
        StudentNode temp = head;

        // Move temp to (position-1)
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is invalid
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        // Adjust links
        newNode.next = temp.next;
        temp.next = newNode;

        // Confirmation message
        System.out.println("Student added at position " + position);
    }

    // -------- Delete student by roll number --------
    void deleteByRoll(int roll) {

        // If list is empty
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If first node needs to be deleted
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }

        // Temporary node for traversal
        StudentNode temp = head;

        // Search node before the target node
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }

        // If student not found
        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            // Skip the target node
            temp.next = temp.next.next;
            System.out.println("Student deleted.");
        }
    }

    // -------- Search student by roll number --------
    void searchByRoll(int roll) {

        // Start from head
        StudentNode temp = head;

        // Traverse list
        while (temp != null) {

            // If roll number matches
            if (temp.rollNumber == roll) {
                System.out.println("Student Found:");
                displayStudent(temp);
                return;
            }

            // Move to next node
            temp = temp.next;
        }

        // If not found
        System.out.println("Student not found.");
    }

    // -------- Update student grade --------
    void updateGrade(int roll, String newGrade) {

        // Start traversal
        StudentNode temp = head;

        // Traverse list
        while (temp != null) {

            // If roll number matches
            if (temp.rollNumber == roll) {

                // Update grade
                temp.grade = newGrade;

                // Confirmation message
                System.out.println("Grade updated successfully.");
                return;
            }

            // Move to next node
            temp = temp.next;
        }

        // If student not found
        System.out.println("Student not found.");
    }

    // -------- Display all students --------
    void displayAll() {

        // If list is empty
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        // Temporary node
        StudentNode temp = head;

        // Traverse entire list
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
    }

    // -------- Display single student --------
    void displayStudent(StudentNode student) {

        // Print student details
        System.out.println("--------------------------------");
        System.out.println("Roll Number : " + student.rollNumber);
        System.out.println("Name        : " + student.name);
        System.out.println("Age         : " + student.age);
        System.out.println("Grade       : " + student.grade);
    }
}

// ================= MAIN CLASS =================
public class StudentRecordManagement {

    public static void main(String[] args) {

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Create linked list object
        StudentLinkedList list = new StudentLinkedList();

        // Variable for menu choice
        int choice;

        // Menu driven program
        do {

            // Display menu
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            // Read choice
            choice = sc.nextInt();

            // Perform operation based on choice
            switch (choice) {

                case 1:
                    list.addAtBeginning(
                            sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 2:
                    list.addAtEnd(
                            sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;

                case 3:
                    list.addAtPosition(
                            sc.nextInt(), sc.nextInt(), sc.next(),
                            sc.nextInt(), sc.next());
                    break;

                case 4:
                    list.deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    list.searchByRoll(sc.nextInt());
                    break;

                case 6:
                    list.updateGrade(sc.nextInt(), sc.next());
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        // Close scanner
        sc.close();
    }
}
