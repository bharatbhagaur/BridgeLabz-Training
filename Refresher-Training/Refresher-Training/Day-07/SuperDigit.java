
import java.util.*;

public class SuperDigit {

    public static int digitSum(int n) {


        // Complete the function.
        if(n<10) return n;


        return n%10 +digitSum(n/10);
    }
    public static int superDigit(int n){
        if(n<10)return n;

        return superDigit(digitSum(n));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int n = scanner.nextInt();

        scanner.close();
        System.out.println(superDigit(n));
    }
}