package one;

public class CombinationSum {


    public static void main(String[] args) {

        int n[] = new int[]{1, 2, 3};
        System.out.println(combinationSum4(n, 4));

    }


    public static int combinationSum4(int[] nums, int target) {

        int f[] = new int[target + 1];
        f[0] = 1;


        for (int i = 1; i <= target; i++) {
            for (int c : nums) {
                int b = i - c;
                if (b >= 0 && f[b] != Integer.MIN_VALUE) {
                    f[i] += f[b];
                }
            }

        }
        return f[target];

    }

}
