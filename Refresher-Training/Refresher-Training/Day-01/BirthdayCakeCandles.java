import java.util.*;

public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = Collections.max(candles);
        int count = 0;

        for (int candle : candles) {
            if (candle == max) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> candles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            candles.add(sc.nextInt());
        }

        int result = birthdayCakeCandles(candles);
        System.out.println(result);

        sc.close();
    }
}