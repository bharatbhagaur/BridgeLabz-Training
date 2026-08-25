//Fibonacci Numbers
import java.util.*;

public class FibonacciNumbers {

    public static int fibonacci(int n) {


        // Complete the function.
        if(n==0 ||n==1)return n;
        int res = fibonacci(n-1)+fibonacci(n-2);
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
