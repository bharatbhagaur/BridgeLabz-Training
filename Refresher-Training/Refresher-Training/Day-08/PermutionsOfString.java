import java.util.*;

 class Main {

    static void generatePermutations(String[] arr, String[] current,
                                      boolean[] used, int index) {

        
        if (index == arr.length) {
            for (String s : current) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }

        // Try every element
        for (int i = 0; i < arr.length; i++) {

            if (!used[i]) {

                // Choose
                used[i] = true;
                current[index] = arr[i];
    
                generatePermutations(arr, current, used, index + 1);

                used[i] = false;
            }
        }
}
    
public class PermutionsOfString{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        String[] arr = new String[n];

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        String[] current = new String[n];
        boolean[] used = new boolean[n];

        generatePermutations(arr, current, used, 0);

        sc.close();
    }
}