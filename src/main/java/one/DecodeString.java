package one;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public static String decodeString(String s) {

        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int n = 0;
                while (Character.isDigit(ch)) {
                    n = n * 10 + ch - '0';
                    i++;
                    ch = s.charAt(i);
                }
                i--;
                num.push(n);
            } else if (Character.isAlphabetic(ch) || ch == '[') {
                str.push(String.valueOf(ch));
            } else if (ch == ']') {
                String pop = str.pop();
                StringBuilder sb = new StringBuilder();
                while (!pop.equals("[")) {
                    sb.insert(0, pop);
                    if (!str.isEmpty()) {
                        pop = str.pop();
                    }
                }
                int n = num.pop();
                StringBuilder sb1 = new StringBuilder();
                while (n > 0) {
                    sb1.append(sb);
                    n--;
                }
                str.push(sb1.toString());
                System.out.println("dsadfad");
            }
        }

        StringBuilder st = new StringBuilder();
        while (!str.isEmpty()) {
            st.insert(0, str.pop());
        }
        return st.toString();
    }
}
