import java.util.*;

public class MAxLength {

    public static String longestEvenLengthWord(String sentence) {

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {

            if (word.length() % 2 == 0 &&
                word.length() > result.length()) {

                result = word;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        System.out.println(longestEvenLengthWord(sentence));

        sc.close();
    }
}