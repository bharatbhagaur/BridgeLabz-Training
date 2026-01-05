import java.util.*;

public class UnionIntersectionSets {

    // Method to find union of two sets
    static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>();

        // Add all elements of set1
        union.addAll(set1);

        // Add all elements of set2
        union.addAll(set2);

        return union;
    }

    // Method to find intersection of two sets
    static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();

        // Check common elements
        for (int element : set1) {
            if (set2.contains(element)) {
                intersection.add(element);
            }
        }
        return intersection;
    }

    // Main method
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

        // -------- Compute Union & Intersection --------
        Set<Integer> union = findUnion(set1, set2);
        Set<Integer> intersection = findIntersection(set1, set2);

        // -------- Output --------
        System.out.println("\nUnion: " + union);
        System.out.println("Intersection: " + intersection);

        sc.close();
    }
}
