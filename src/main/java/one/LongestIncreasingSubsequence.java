package one;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int i[] = new int[]{7, 7, 7, 7};

        System.out.println(lengthOfLIS(i));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }

        int f[] = new int[nums.length];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], 1 + f[j]);
                }

            }

        }

        int max = -1;
        for (int i : f) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}
