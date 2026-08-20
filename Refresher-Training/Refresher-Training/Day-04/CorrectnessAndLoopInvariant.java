//Correctness and the Loop Invariant
import java.io.*;
import java.util.*;

public class CorrectnessAndLoopInvariant {

   public static void insertionSort(int n , int[] arr){
       
    for(int i=1;i<n;i++){
        int k=arr[i];
        int j=i-1;
        
        while(j>=0 && arr[j]> k){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=k;
    }
    for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
    }
    
   }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        insertionSort(n, arr);
    }
}