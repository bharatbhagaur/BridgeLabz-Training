import java.util.*;

public class CommonCharacter {

    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<>(
            Arrays.asList("ae", "bc", "zx")
        );

        ArrayList<String> B = new ArrayList<>(
            Arrays.asList("ab", "vb", "op")
        );

        for (int i = 0; i < A.size(); i++) {

            HashSet<Character> set = new HashSet<>();

        
            for (char ch : A.get(i).toCharArray()) {
                set.add(ch);
            }

            boolean found = false;

    
            for (char ch : B.get(i).toCharArray()) {

                if (set.contains(ch)) {
                    found = true;
                    break;
                }
            }

            System.out.println(found ? "YES" : "NO");
        }
    }
}