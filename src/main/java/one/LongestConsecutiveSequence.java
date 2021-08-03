package one;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i : nums) {
            s.add(i);
        }

        int max = 0;
        for (int num : nums) {

            int l = num - 1;
            int r = num + 1;

            if (s.contains(l)) {
                continue;
            }

            int len = 1;
            while (s.contains(r)) {
                len++;
                r++;
            }
            max = Math.max(max, len);


        }
        return max;

    }
}
