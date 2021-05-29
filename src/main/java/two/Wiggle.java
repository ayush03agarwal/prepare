package two;

public class Wiggle {
    public static void main(String[] args) {

        System.out.println(wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
    }

    public static int wiggleMaxLength(int[] nums) {

        int t1 = 0;
        int c = 1;

        if (nums.length == 1) {
            return 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int s = nums[i - 1] - nums[i];
            if (t1 == -1) {
                if (s >= 0) {
                    continue;
                }
            }

            if (t1 == 1) {
                if (s <= 0) {
                    continue;
                }
            }

            if (s < 0) {
                t1 = 1;
            } else if (s > 0) {
                t1 = -1;
            }

            if (s != 0)
                c++;

        }
        return c;
    }

}
