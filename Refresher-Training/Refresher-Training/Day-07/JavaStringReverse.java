//Java String Reverse
import java.io.*;
import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
       int n=A.length();
       
       StringBuilder sb = new StringBuilder(A);
       String revString = sb.reverse().toString();
       if(A.equals(revString)){
        System.out.println("Yes");
       }else{
        System.out.println("No");
       }
        
        
    }
}



