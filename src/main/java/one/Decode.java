package one;

import java.util.Stack;

public class Decode {


    public static void main(String[] args) {

        System.out.println(decode("1[b10[ca]]"));
    }


    static String decode(String str) {

        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                intStack.push(count);
                count = 0;
            } else if (Character.isAlphabetic(str.charAt(i)) || str.charAt(i) == '[') {
                charStack.push(str.charAt(i));
            } else {
                while (charStack.peek() != '[') {
                    char ch = charStack.pop();
                    res.insert(0, ch);
                }
                charStack.pop();

                int times = intStack.pop();
                StringBuilder result = new StringBuilder();
                while (times > 0) {
                    result.append(res);
                    times--;
                }

                for (int k = 0; k < result.length(); k++) {
                    charStack.push(result.charAt(k));
                }

                res = new StringBuilder();

            }
        }

        while (!charStack.isEmpty()) {
            res.append(charStack.pop());
        }
        return res.reverse().toString();

    }
}
