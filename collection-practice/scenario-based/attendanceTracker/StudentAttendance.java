package attendanceTracker;

import java.util.*;

public class StudentAttendance {

    // To avoid duplicate student ids globally (optional)
    Set<String> ids = new HashSet<>();

    // Session-wise attendance: SessionID -> Set of StudentIDs
    Map<String, Set<String>> trackAttendance = new HashMap<>();

    // Mark attendance
    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {

        // Create session if not exists
        trackAttendance.putIfAbsent(sessionId, new HashSet<>());

        Set<String> sessionStudents = trackAttendance.get(sessionId);

        // If already marked, throw exception
        if (sessionStudents.contains(studentId)) {
            throw new DuplicateAttendanceException("Attendance already marked for Student: " + studentId);
        }

        sessionStudents.add(studentId);
        ids.add(studentId);

        System.out.println("Attendance marked for Student " + studentId + " in Session " + sessionId);
    }

    // Remove attendance
    public void removeAttendance(String sessionId, String studentId) {

        Set<String> sessionStudents = trackAttendance.get(sessionId);

        if (sessionStudents != null && sessionStudents.remove(studentId)) {
            System.out.println("Attendance removed for Student " + studentId + " from Session " + sessionId);
        } else {
            System.out.println("Attendance record not found.");
        }
    }

    // Display attendance
    public void displayAttendance(String sessionId) {

        Set<String> sessionStudents = trackAttendance.get(sessionId);

        if (sessionStudents == null || sessionStudents.isEmpty()) {
            System.out.println("No attendance for Session " + sessionId);
            return;
        }

        System.out.println("Attendance for Session " + sessionId + ":");
        for (String id : sessionStudents) {
            System.out.println("- Student ID: " + id);
        }
    }
}
