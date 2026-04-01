package json;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidator {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // read and parse json
            mapper.readTree(new File("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\users.json"));

            // if no exception, json is valid
            System.out.println("JSON structure is valid");

        } catch (Exception e) {
            // invalid json format
            System.out.println("Invalid JSON structure");
            System.out.println(e.getMessage());
        }
    }
}
