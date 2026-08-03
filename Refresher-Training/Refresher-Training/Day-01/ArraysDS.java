import java.util.*;
//ArraysDS
public class ArraysDS {

    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> reverse = new ArrayList<>();

        for (int i = a.size() - 1; i >= 0; i--) {
            reverse.add(a.get(i));
        }

        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        List<Integer> result = reverseArray(a);

        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}