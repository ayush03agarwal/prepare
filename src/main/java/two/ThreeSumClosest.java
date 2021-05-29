package two;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new Integer[]{-4, 0, 2, 1, -3, 5, 6}, 1));
    }

    public static int threeSumClosest(Integer[] nums, int target) {
        Arrays.sort(nums);

        int f = Integer.MAX_VALUE;
        int a = nums[0];
        int j = nums.length - 1;
        int b = nums[j];
        int c = 0;
        int i = 1;
        int pos = Integer.MAX_VALUE;

        //   -4 , -3 , 0 , 1, 2 , 5, 6

        while (i < j) {
            c = nums[i];
            int s = c + a + b;
            if (s < target) {
                a = nums[i++];
            } else {
                b = nums[j--];
            }
            if (pos > Math.abs(target - s)) {
                pos = Math.abs(target - s);
                f = Math.abs(s);
            }
        }
        return f;
    }
}