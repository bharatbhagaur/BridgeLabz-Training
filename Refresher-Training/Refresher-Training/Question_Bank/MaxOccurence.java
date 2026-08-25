import java.util.*;

public class MaxOccurence {

    public static char maximumOccurringCharacter(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char result = str.charAt(0);
        int max = 0;

        // Find maximum frequency
        for (char ch : str.toCharArray()) {

            if (map.get(ch) > max) {
                max = map.get(ch);
                result = ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(maximumOccurringCharacter(str));

        sc.close();
    }
}