package two;

public class RemoveAllInstances {
    public static void main(String[] args) {

        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {

        int c = 0;
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                c++;
            }
            if (nums[i] == val && p == -1) {
                p = i;
            } else if (nums[i] != val && p != -1) {
                swap(nums, p, i);
                i = p;
                p = -1;

            }
        }
        return c;
    }

    private static void swap(int[] a, int i, int j) {
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }
}
