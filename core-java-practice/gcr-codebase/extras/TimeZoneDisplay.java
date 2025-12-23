import java.time.ZonedDateTime; // class to handle date & time with zone
import java.time.ZoneId;        // class to represent time zones

public class TimeZoneDisplay {

    public static void main(String[] args) {

        // Get current time in GMT (Greenwich Mean Time)
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));

        // Get current time in IST (Indian Standard Time)
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        // Get current time in PST (Pacific Standard Time)
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Display all times
        System.out.println("Current Time in GMT: " + gmtTime);
        System.out.println("Current Time in IST: " + istTime);
        System.out.println("Current Time in PST: " + pstTime);
    }
}
