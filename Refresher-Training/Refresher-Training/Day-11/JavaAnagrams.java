//Java Anagrams
import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length()!=b.length())return false;
        
        int[] freq = new int[26];
        
        for(char c:a.toLowerCase().toCharArray()){
            freq[c-'a']++;
        }
        for(char c:b.toLowerCase().toCharArray()){
            freq[c-'a']--;
        }
        for(int i : freq){
            if(i!=0)return false;
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
