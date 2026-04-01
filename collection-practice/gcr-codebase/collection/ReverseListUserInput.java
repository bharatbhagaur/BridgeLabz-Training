import java.util.*;

public class ReverseListUserInput {

    // ---------- Reverse ArrayList using two pointers ----------
    static void reverseArrayList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    // ---------- Reverse LinkedList without built-in reverse ----------
    static void reverseLinkedList(LinkedList<Integer> list) {

        // Step 1: Copy elements into an array
        Integer[] arr = new Integer[list.size()];
        int index = 0;
        for (int num : list) {
            arr[index++] = num;
        }

        // Step 2: Reverse the array manually
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        // Step 3: Put elements back into LinkedList
        list.clear();
        for (int num : arr) {
            list.add(num);
        }
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // ---------- ArrayList Input ----------
        List<Integer> arrayList = new ArrayList<>();
        System.out.println("Enter elements for ArrayList:");
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        // Reverse ArrayList
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // ---------- LinkedList Input ----------
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("\nEnter elements for LinkedList:");
        for (int i = 0; i < n; i++) {
            linkedList.add(sc.nextInt());
        }

        // Reverse LinkedList
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);

    
    }
}
