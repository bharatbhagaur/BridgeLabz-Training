import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int stepPerms(int n) {
    // Write your code here
    if(n<0 ) return 0;
    if(n==0 || n==1) return 1;
    if(n==2) return 2;

    return stepPerms(n-1)+stepPerms(n-2)+stepPerms(n-3);

    }

}

public class StairCases
 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        for (int sItr = 0; sItr < s; sItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int res = Result.stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
