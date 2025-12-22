import java.util.Scanner;

class CharacterFrequency {

    // Method to find character frequency
    static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();   // storing characters
        int[] freq = new int[chars.length];  // frequency array

        // Outer loop for each character
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;

            // Inner loop to find duplicate characters
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Store result in String array
        String[] result = new String[chars.length];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " : " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] output = findFrequency(input);

        System.out.println("Character Frequencies:");
        for (String s : output) {
            if (s != null)
                System.out.println(s);
        }

        sc.close();
    }
}
