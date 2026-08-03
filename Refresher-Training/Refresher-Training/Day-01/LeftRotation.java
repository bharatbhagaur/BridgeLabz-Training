import java.util.*;
//LeftRotation
public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int n = a.size();
        List<Integer> result = new ArrayList<>();

        d = d % n;

        for (int i = 0; i < n; i++) {
            result.add(a.get((i + d) % n));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        List<Integer> result = rotLeft(a, d);

        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}