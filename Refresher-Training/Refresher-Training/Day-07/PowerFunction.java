
import java.util.*;

public class PowerFunction {

    public static int powerFunction(int x,int n) {


        // Complete the function.
        if(n==0)return 1;

        int half = powerFunction(x,n//2);
        if(n%2==0) return half*half;


        return half*half*x;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        scanner.close();
        System.out.println(fibonacci(x,n));
    }
}