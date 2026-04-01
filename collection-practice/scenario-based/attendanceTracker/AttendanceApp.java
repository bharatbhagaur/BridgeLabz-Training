package attendanceTracker;



import java.util.Scanner;

public class AttendanceApp {

    public static void main(String[] args) {

        StudentAttendance attendance = new StudentAttendance();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Remove Attendance");
            System.out.println("3. Display Attendance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Session ID: ");
                    String sessionId = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();

                    try {
                        attendance.markAttendance(sessionId, studentId);
                    } catch (DuplicateAttendanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Session ID: ");
                    String removeSessionId = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String removeStudentId = sc.nextLine();

                    attendance.removeAttendance(removeSessionId, removeStudentId);
                    break;

                case 3:
                    System.out.print("Enter Session ID: ");
                    String displaySessionId = sc.nextLine();

                    attendance.displayAttendance(displaySessionId);
                    break;

                case 4:
                    System.out.println("Exiting Attendance App... 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice ❌");
            }
        }
    }
}
