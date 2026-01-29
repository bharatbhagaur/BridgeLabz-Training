package functionalinterface;

//Marker interface with no methods
interface BackupSerializable {
}

//Class marked for backup
class EmployeeRecord implements BackupSerializable {

 private int employeeId;
 private String employeeName;

 public EmployeeRecord(int id, String name) {
     this.employeeId = id;
     this.employeeName = name;
 }

 public String getDetails() {
     return employeeId + " - " + employeeName;
 }
}

//Class not marked for backup
class TemporaryCache {

 private String cacheData;

 public TemporaryCache(String data) {
     this.cacheData = data;
 }

 public String getCacheData() {
     return cacheData;
 }
}

//Backup processor
class BackupManager {

 public static void performBackup(Object obj) {

     if (obj instanceof BackupSerializable) {
         System.out.println("Object eligible for backup: " + obj.getClass().getSimpleName());
     } else {
         System.out.println("Object is not eligible for backup: " + obj.getClass().getSimpleName());
     }
 }
}

//Main class
public class BackupApplication {

 public static void main(String[] args) {

     EmployeeRecord record = new EmployeeRecord(101, "Rahul");
     TemporaryCache cache = new TemporaryCache("Session data");

     BackupManager.performBackup(record);
     BackupManager.performBackup(cache);
 }
}

