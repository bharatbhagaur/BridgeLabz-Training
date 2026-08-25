import java.util.*;

public class MaxFrequencyCharacter {

    static int getIndex(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        }

        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 26;
        }

        return ch - '0' + 52;
    }

    public static char maximumFrequency(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char result = s.charAt(0);
        int max = 0;

        // Find maximum frequency
        for (char ch : map.keySet()) {

            int frequency = map.get(ch);

            if (frequency > max) {

                max = frequency;
                result = ch;

            } else if (frequency == max) {

                // Tie → choose smaller index
                if (getIndex(ch) < getIndex(result)) {
                    result = ch;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(maximumFrequency(s));

        sc.close();
    }
}