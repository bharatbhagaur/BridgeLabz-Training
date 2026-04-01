// Import Scanner class for taking user input
import java.util.Scanner;

// ================= TASK NODE CLASS =================
class TaskNode {

    // Stores task ID
    int taskId;

    // Stores task name
    String taskName;

    // Stores task priority
    String priority;

    // Stores task due date
    String dueDate;

    // Pointer to next task (circular)
    TaskNode next;

    // Constructor to initialize task details
    TaskNode(int taskId, String taskName, String priority, String dueDate) {

        // Assign task ID
        this.taskId = taskId;

        // Assign task name
        this.taskName = taskName;

        // Assign priority
        this.priority = priority;

        // Assign due date
        this.dueDate = dueDate;

        // Initialize next as null
        this.next = null;
    }
}

// ================= CIRCULAR LINKED LIST CLASS =================
class TaskCircularLinkedList {

    // Head pointer (first task)
    TaskNode head;

    // Pointer to keep track of current task
    TaskNode current;

    // -------- Add task at beginning --------
    void addAtBeginning(int id, String name, String priority, String date) {

        // Create new task node
        TaskNode newNode = new TaskNode(id, name, priority, date);

        // If list is empty
        if (head == null) {

            // Point node to itself
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        // Temporary node to reach last task
        TaskNode temp = head;

        // Traverse to last node
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert new node at beginning
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // -------- Add task at end --------
    void addAtEnd(int id, String name, String priority, String date) {

        // Create new task node
        TaskNode newNode = new TaskNode(id, name, priority, date);

        // If list is empty
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        // Temporary node to traverse
        TaskNode temp = head;

        // Reach last node
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert at end
        temp.next = newNode;
        newNode.next = head;
    }

    // -------- Add task at specific position --------
    void addAtPosition(int position, int id, String name, String priority, String date) {

        // If inserting at first position
        if (position == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        // Create new task node
        TaskNode newNode = new TaskNode(id, name, priority, date);

        // Temporary node
        TaskNode temp = head;

        // Move to (position - 1)
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        // Insert node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // -------- Remove task by Task ID --------
    void removeByTaskId(int id) {

        // If list is empty
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        // Loop through circular list
        do {

            // If task found
            if (temp.taskId == id) {

                // If only one node exists
                if (temp == head && temp.next == head) {
                    head = null;
                    current = null;
                    System.out.println("Task removed.");
                    return;
                }

                // If deleting head
                if (temp == head) {

                    // Find last node
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    // Update head
                    head = head.next;
                    last.next = head;
                }
                else {
                    // Remove middle or last node
                    prev.next = temp.next;
                }

                System.out.println("Task removed.");
                return;
            }

            // Move pointers
            prev = temp;
            temp = temp.next;

        } while (temp != head);

        // If task not found
        System.out.println("Task not found.");
    }

    // -------- View current task and move to next --------
    void viewNextTask() {

        // If no tasks
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        // Display current task
        displayTask(current);

        // Move to next task
        current = current.next;
    }

    // -------- Display all tasks --------
    void displayAllTasks() {

        // If list empty
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        // Temporary node
        TaskNode temp = head;

        // Traverse circular list
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // -------- Search task by priority --------
    void searchByPriority(String priority) {

        // If list empty
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        // Traverse circular list
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        // If no matching task
        if (!found) {
            System.out.println("No task found with given priority.");
        }
    }

    // -------- Display single task --------
    void displayTask(TaskNode task) {

        System.out.println("--------------------------------");
        System.out.println("Task ID    : " + task.taskId);
        System.out.println("Task Name  : " + task.taskName);
        System.out.println("Priority   : " + task.priority);
        System.out.println("Due Date   : " + task.dueDate);
    }
}

// ================= MAIN CLASS =================
public class TaskScheduler {

    public static void main(String[] args) {

        // Scanner object
        Scanner sc = new Scanner(System.in);

        // Create circular linked list object
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();

        int choice;

        // Menu driven program
        do {
            System.out.println("\n===== Task Scheduler =====");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            // Read choice
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    scheduler.addAtBeginning(
                            sc.nextInt(), sc.next(), sc.next(), sc.next());
                    break;

                case 2:
                    scheduler.addAtEnd(
                            sc.nextInt(), sc.next(), sc.next(), sc.next());
                    break;

                case 3:
                    scheduler.addAtPosition(
                            sc.nextInt(), sc.nextInt(), sc.next(),
                            sc.next(), sc.next());
                    break;

                case 4:
                    scheduler.removeByTaskId(sc.nextInt());
                    break;

                case 5:
                    scheduler.viewNextTask();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    scheduler.searchByPriority(sc.next());
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        // Close scanner
        sc.close();
    }
}
