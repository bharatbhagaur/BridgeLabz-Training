import java.util.Scanner;

public class CharFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");

        String str = sc.nextLine();

        int[] freq = new int[256]; 

        // count the frequncy of each character in string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        System.out.println("\nCharacter Frequency:");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] != 0) {
                System.out.println(ch + " : " + freq[ch]);
                freq[ch] = 0; 
            }
        }

        
    }
}
