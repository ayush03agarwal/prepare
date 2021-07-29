package one;

public class RotatedArray {


    public static void main(String[] args) {

        int n[] = new int[]{3, 1};
        System.out.println(search(n, 3));

    }

    public static int search(int[] nums, int target) {

        int pivot = -1;

        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }


        if (nums[0] < nums[nums.length - 1]) {
            pivot = 0;
        } else {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] > nums[r]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            pivot = l;
        }


        int l = 0;
        int r = nums.length - 1;

        if (pivot != 0) {
            if (target >= nums[0]) {
                r = pivot - 1;
            } else {
                l = pivot;
            }
        }

        while (l < r) {
            int m = l + (r - l) / 2;

            if (target == nums[m]) {
                return m;
            } else if (target < nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return target == nums[l] ? l : -1;

    }


}
