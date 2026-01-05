import java.util.*;

public class CheckSubset {

    // Method to check if set1 is subset of set2
    static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {

        // Check each element of set1
        for (int element : set1) {
            if (!set2.contains(element)) {
                return false; // element not found
            }
        }
        return true; // all elements found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- Input for Set 1 --------
        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // -------- Input for Set 2 --------
        System.out.print("\nEnter number of elements in Set 2: ");
        int n2 = sc.nextInt();

        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // -------- Subset Check --------
        boolean result = isSubset(set1, set2);

        // -------- Output --------
        System.out.println("\nIs Set 1 a subset of Set 2? " + result);

        sc.close();
    }
}
