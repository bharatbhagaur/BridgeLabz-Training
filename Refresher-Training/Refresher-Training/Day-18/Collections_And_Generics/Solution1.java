import java.util.*;

public class Solution1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> phoneBook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int phone = sc.nextInt();

            phoneBook.put(name, phone);
        }

        while (sc.hasNext()) {
            String name = sc.next();

            if (phoneBook.containsKey(name)) {
                System.out.println(name + "=" + phoneBook.get(name));
            } else {
                System.out.println("Not found");
            }
        }

        sc.close();
    }
}