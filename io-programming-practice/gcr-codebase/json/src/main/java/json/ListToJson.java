package json;
import java.util.ArrayList;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class ListToJson {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bharat", 90));
        students.add(new Student(2, "Aman", 85));
        students.add(new Student(3, "Rohit", 88));

        // ✅ JSON Array
        JSONArray jsonArray = new JSONArray();

        for (Student s : students) {
            JSONObject obj = new JSONObject();
            obj.put("id", s.id);
            obj.put("name", s.name);
            obj.put("marks", s.marks);

            jsonArray.put(obj);
        }

        // ✅ Print JSON Array
        System.out.println(jsonArray.toString(2)); // pretty print
    }
}
