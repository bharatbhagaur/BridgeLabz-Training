import java.util.*;

public class CompareTwoSets {

    // Method to check if two sets are equal
    static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {

        // equals() checks size and elements (order does NOT matter)
        return set1.equals(set2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------- Input for Set 1 ----------
        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // ---------- Input for Set 2 ----------
        System.out.print("\nEnter number of elements in Set 2: ");
        int n2 = sc.nextInt();

        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // ---------- Comparison ----------
        boolean result = areSetsEqual(set1, set2);

        // Output result
        System.out.println("\nAre both sets equal? " + result);

        sc.close();
    }
}
