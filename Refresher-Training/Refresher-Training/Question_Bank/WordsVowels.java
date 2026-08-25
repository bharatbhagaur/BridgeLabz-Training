import java.util.*;

public class WordsVowels {

    static boolean isVowel(char ch) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        ch = Character.toLowerCase(ch);

        for (char vowel : vowels) {
            if (ch == vowel) {
                return true;
            }
        }

        return false;
    }

    static List<String> vowelWords(String[] words) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (isVowel(word.charAt(0)) &&
                isVowel(word.charAt(word.length() - 1))) {

                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words = {
            "apple",
            "banana",
            "orange",
            "India",
            "hello",
            "area"
        };

        System.out.println(vowelWords(words));
    }
}