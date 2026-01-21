package json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONObject;

public class ReadJsonFile {

    public static void main(String[] args) {

        try {
            // ✅ Read JSON file as String
            String content = new String(
                    Files.readAllBytes(Paths.get("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\data.json"))
            );

            // ✅ Convert String to JSONObject
            JSONObject jsonObject = new JSONObject(content);

            // ✅ Get all keys
            Iterator<String> keys = jsonObject.keys();

            // ✅ Print key and value
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);

                System.out.println(key + " : " + value);
            }

        } catch (IOException e) {
            System.out.println("File not found or error reading file");
            e.printStackTrace();
        }
    }
}
