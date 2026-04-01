package json;

import org.json.JSONObject;

public class MergeJson {

    public static void main(String[] args) {

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Bharat");
        obj1.put("age", 25);

        JSONObject obj2 = new JSONObject();
        obj2.put("city", "Delhi");
        obj2.put("country", "India");

        // merge obj2 into obj1
        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        // print merged json
        System.out.println(obj1.toString(2));
    }
}
