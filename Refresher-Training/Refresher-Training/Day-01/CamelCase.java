import java.util.*;
//Camelcase
public class CamelCase {

    public static int camelcase(String s) {
        int count = 1;

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int result = camelcase(s);
        System.out.println(result);

        sc.close();
    }
}