package one;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int n[] = new int[]{-2, 0, -1, -1};
        int i = maxProduct(n);
        System.out.println(i);

    }

    public static int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int l = 1;
        int r = 1;

        int lmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            l = l * nums[i];
            lmax = Math.max(lmax, l);
            if (nums[i] == 0) {
                l = 1;
            }
        }


        int rmax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            r = r * nums[i];
            rmax = Math.max(rmax, r);
            if (nums[i] == 0) {
                r = 1;
            }
        }


        return Math.max(rmax, lmax);
    }


}
