package one;

public class MaximumSubarray {
    public static void main(String[] args) {

        int n[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(n);
        System.out.println(i);

    }

    public static int maxSubArray(int[] nums) {

        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }


        return result;


    }
}
