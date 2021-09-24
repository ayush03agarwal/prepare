package one;

public class SplitArrayLargestSum {

    public static void main(String[] args) {

        int n[] = {2, 3, 1, 1, 1, 1, 1};
        System.out.println(splitArray(n, 5));
    }


    public static int splitArray(int[] nums, int m) {
        int high = 0;
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            high += nums[i];
            low = Math.max(low, nums[i]);
        }
        if (m == nums.length) {
            return high;
        }


        int ans = Integer.MAX_VALUE;
        while (high >= low) {

            int arr = 1;
            int mid = low + (high - low) / 2;

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > mid) {
                    arr++;
                    sum = nums[i];
                }
            }

            if (arr <= m) {
                if (arr == m) {
                    ans = Math.min(ans, mid);
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans == Integer.MAX_VALUE ? Math.max(high, low) : ans;


    }


    private static int split(int[] nums, int start, int end, int m) {
        if (end < start) {
            return Integer.MAX_VALUE;
        }

        int mid = start + (end - start) / 2;
        int arr = 1;
        int sum = 0;
        int largestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                sum = nums[i];
                arr++;
            }
        }

        int val = 0;
        if (arr <= m) {
            if (arr == m) {
                largestSum = mid;
            }
            val = split(nums, start, mid - 1, m);
        } else {
            val = split(nums, mid + 1, end, m);
        }
        largestSum = Math.min(largestSum, val);

        return largestSum;

    }
}
