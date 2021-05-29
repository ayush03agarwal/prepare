package two;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("hrqcvsvszpsjammdrw"));
    }

    public static String firstNonRepeating(String A) {

        StringBuilder f = new StringBuilder();

        Queue<Character> q = new LinkedList<>();
        int[] a = new int[26];

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            a[c - 97] = a[c - 97] + 1;

            if (a[c - 97] == 1) {
                q.add(c);
            } else {
                q.remove(c);
            }
            if (q.isEmpty()) {
                f.append("#");
            } else {
                f.append(q.peek());
            }
        }

        return f.toString();

    }

}
