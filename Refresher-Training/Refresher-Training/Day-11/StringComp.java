import java.util.Scanner;

public class StringComp {

    public static String compress(String s) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            int count = 0;

            while (i < s.length() && s.charAt(i) == ch) {
                count++;
                i++;
            }

            result.append(ch);
            result.append(count);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        String result = compress(s);

        System.out.println("Compressed string: " + result);

        sc.close();
    }
}