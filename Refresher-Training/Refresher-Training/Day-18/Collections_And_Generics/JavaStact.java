import java.util.*;

public class JavaStack {

    public static void main(String[] argh) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String input = sc.next();

            Stack<Character> stack = new Stack<>();

            boolean valid = true;

            for (char ch : input.toCharArray()) {

                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } 
                else {

                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }

                    char top = stack.pop();

                    if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {

                        valid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                valid = false;
            }

            System.out.println(valid);
        }

        sc.close();
    }
}