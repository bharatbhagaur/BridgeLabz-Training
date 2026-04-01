package LexicalTwist;

import java.util.Scanner;

public class LexicalTwist {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String firstWord = sc.nextLine();

        System.out.println("Enter the second word");
        String secondWord = sc.nextLine();

        String firstWordLower = firstWord.toLowerCase();

        // reverse first word
        StringBuilder reverse = new StringBuilder();
        for (int i = firstWordLower.length() - 1; i >= 0; i--) {
            reverse.append(firstWordLower.charAt(i));
        }

        String reversedWord = reverse.toString();
        StringBuilder output = new StringBuilder();
        StringBuilder outputVowel = new StringBuilder();
        StringBuilder outputConsonant = new StringBuilder();

        int vowelCount = 0;
        int consonantCount = 0;
        if(consonantCount==vowelCount) {
        	System.out.println(" Vowels and consonants are equal");
        }

        if (secondWord.equalsIgnoreCase(reversedWord)) {

            for (char c : reversedWord.toCharArray()) {

                if (c == 'a' || c == 'e' || c == 'i'
                        || c == 'o' || c == 'u') {

                    output.append('@');
                    vowelCount++;

                } else {
                    output.append(c);
                    consonantCount++;
                }
            }

            System.out.println("Output String: " + output);
            System.out.println("Vowels replaced: " + vowelCount);
            System.out.println("Consonants count: " + consonantCount);

        } else {
              int count=0;
              int count2=0;
            String merged =
                    (firstWord + secondWord).toUpperCase();
            for(char c : merged.toCharArray()) {
            	if(c=='A'||c=='I'||c=='O'||c=='U'||c=='E') {
            		outputVowel.append(c);
            		count++;
            		if(count==2) {
            			System.out.println(outputVowel);
            		}
            	}else {
            		
            		if(consonantCount>vowelCount) {
            		outputConsonant.append(c);
            		count2++;
            		if(count2==2) {
            			System.out.println(outputConsonant);
            		}
            		}
            	}
            }

            System.out.println("Merged String: " + merged);
        }

        sc.close();
    }
}
