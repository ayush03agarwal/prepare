package two;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        System.out.println(ispar("{([])"));
    }

    static boolean ispar(String x) {

        Stack<Character> s = new Stack<>();
        for (char c : x.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                s.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char p = s.peek();
                if (p == '{' && c == '}') {
                    s.pop();
                    continue;
                } else if (p == '(' && c == ')') {
                    s.pop();
                    continue;
                } else if (p == '[' && c == ']') {
                    s.pop();
                    continue;
                }
                return false;
            }
        }

        if (s.isEmpty()) {
            return true;
        }
        return false;


    }
}
