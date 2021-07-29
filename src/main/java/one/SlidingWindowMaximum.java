package one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int a[] = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(a, 3);
        Stack<Integer> s = new Stack<>();

        System.out.println(Arrays.toString(ints));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int l = 0;
        int r = 0;
        int c = 0;
        q.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int a = q.peek();
            if (c < k) {

                if (a < nums[i]) {
                    q.remove();
                }
                c++;
            } else {
                if (a == nums[l]) {
                    q.remove();
                }
                int b = q.peek();
                while (b < nums[i]) {
                    q.remove();
                    b = q.peek();
                }
            }
            q.add(nums[i]);
        }
        return new int[]{};
    }
}
