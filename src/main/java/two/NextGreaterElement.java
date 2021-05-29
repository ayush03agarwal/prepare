package two;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println(nextLargerElement(new long[]{7, 8, 1, 4}, 3));
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        long[] l = new long[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                l[s.peek()] = arr[i];
                s.pop();
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            l[s.peek()] = -1;
            s.pop();
        }
        return l;
    }
}
