
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int simpleArraySum(List<Integer> ar) {
        int sum = 0;

        for (int num : ar) {
            sum += num;
        }

        return sum;
    }
}

public class SimpleArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = Result.simpleArraySum(ar);

        System.out.println(result);

        bufferedReader.close();
    }
}