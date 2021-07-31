package one;

public class HouseRobber {
    public static void main(String[] args) {
        int n[] = {2, 7, 9, 3, 1, 14};
        System.out.println(rob(n));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int d[] = new int[nums.length];
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            d[i] = Math.max(nums[i] + d[i - 2], d[i - 1]);
        }
        return d[nums.length - 1];
    }
}
