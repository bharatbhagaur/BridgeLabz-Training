package json;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterUsers {

    public static void main(String[] args) {

        try {
            // ead file content
            String content = new String(
                    Files.readAllBytes(Paths.get("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\users.json"))
            );

            // Convert to JSON Array
            JSONArray users = new JSONArray(content);

            System.out.println("Users older than 25:\n");

            //  Loop through JSON array
            for (int i = 0; i < users.length(); i++) {

                JSONObject user = users.getJSONObject(i);
                int age = user.getInt("age");

                //  Filter condition
                if (age > 25) {
                    System.out.println(
                        "Name: " + user.getString("name") +
                        ", Age: " + age +
                        ", City: " + user.getString("city")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
