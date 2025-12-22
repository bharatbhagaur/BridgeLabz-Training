import java.util.Scanner;

class AnagramCheck {

    static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Count frequency of characters
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }

        // Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.next();

        System.out.print("Enter second text: ");
        String text2 = sc.next();

        System.out.println("Are they anagrams? " + isAnagram(text1, text2));

        
    }
}
