package one;

public class SegmentTree {

    int[] segment;
    int[] nums;

    public SegmentTree(int[] nums) {
        segment = new int[2 * nums.length + 1];
        this.nums = nums;
        constructSegement(0, nums.length - 1, 0);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 5, 6, 7, 9};
        SegmentTree tree = new SegmentTree(num);
        System.out.println(tree.sumRange(2, 4));

    }

    private int constructSegement(int left, int right, int sIndex) {

        if (left > right) {
            return 0;
        }

        if (left == right) {
            segment[sIndex] = nums[left];
            return segment[sIndex];
        }

        int mid = left + (right - left) / 2;

        int lc = 2 * sIndex + 1;
        int rc = 2 * sIndex + 2;

        int lt = constructSegement(left, mid, lc);
        int rt = constructSegement(mid + 1, right, rc);

        segment[sIndex] = lt + rt;

        return segment[sIndex];

    }

    public int sumRange(int left, int right) {


        return getSum(0, nums.length - 1, 0, left, right);


    }

    private int getSum(int leftRange, int rightRange, int segIndex, int left, int right) {

        if (leftRange >= left && rightRange <= right) {
            return segment[segIndex];
        }

        if (leftRange > right || rightRange < left) {
            return 0;
        }

        int mid = (leftRange + rightRange) / 2;

        int lt = getSum(leftRange, mid, 2 * segIndex + 1, left, right);
        int rt = getSum(mid + 1, rightRange, 2 * segIndex + 2, left, right);

        return lt + rt;


    }

}
