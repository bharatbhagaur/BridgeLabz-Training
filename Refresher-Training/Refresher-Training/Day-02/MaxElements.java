import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code 
     List<Integer> res = new ArrayList<>();
     Stack<Integer> st = new Stack<>();
     Stack<Integer> maxSt = new Stack<>();
      
      maxSt.push(Integer.MIN_VALUE);
      
      for(String str : operations){
        String[] opParts = str.split(" ");
        int op = Integer.parseInt((opParts[0]));
        if(op==1){
            int x = Integer.parseInt(opParts[1]);
            st.push(x);
            if(x>maxSt.peek()){
                maxSt.push(x);
            }else{
                maxSt.push(maxSt.peek());
            }
        }
        else if (op==2){
            st.pop();
            maxSt.pop();
        }
        else if(op==3){
            res.add(maxSt.peek());
            
        }
          }
  return res;
    }

}

public class MaxElements {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
