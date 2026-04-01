package functionalinterface;

//Custom marker interface
interface EncryptedData {
}

//Class marked as sensitive
class CustomerCredentials implements EncryptedData {

 private String username;
 private String password;

 public CustomerCredentials(String user, String pass) {
     this.username = user;
     this.password = pass;
 }

 public String getInfo() {
     return "User: " + username;
 }
}

//Class not marked as sensitive
class PublicProfile {

 private String displayName;

 public PublicProfile(String name) {
     this.displayName = name;
 }

 public String getDisplayName() {
     return displayName;
 }
}

//Encryption processor
class EncryptionManager {

 public static void secureObject(Object obj) {

     if (obj instanceof EncryptedData) {
         System.out.println("Object requires encryption: " + obj.getClass().getSimpleName());
     } else {
         System.out.println("Object does not require encryption: " + obj.getClass().getSimpleName());
     }
 }
}

//Main class
public class DataSecurityApp {

 public static void main(String[] args) {

     CustomerCredentials credentials = new CustomerCredentials("admin", "pass123");
     PublicProfile profile = new PublicProfile("AdminUser");

     EncryptionManager.secureObject(credentials);
     EncryptionManager.secureObject(profile);
 }
}

