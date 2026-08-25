import java.util.*;

public class CountPalindromicStrings {

    public static int countPalindromes(List<List<String>> list) {

        int count = 0;

        for (List<String> row : list) {

            for (String str : row) {

                if (isPalindrome(str)) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        List<List<String>> list = new ArrayList<>();

        list.add(Arrays.asList("madam", "hello", "level"));
        list.add(Arrays.asList("java", "racecar", "world"));
        list.add(Arrays.asList("noon", "abc"));

        System.out.println(countPalindromes(list));
    }
}