package json;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {

    public static void main(String[] args) {

        // create json object
        JSONObject student = new JSONObject();

        student.put("name", "Bharat");
        student.put("age", 22);

        // create subjects array
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");
        subjects.put("Computer Science");

        // add array to json object
        student.put("subjects", subjects);

        // print json
        System.out.println(student.toString(2));
    }
}
