package one;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {


        int[] n = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(n));
    }


    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = bst(nums, 0, nums.length - 1);

        return root;
    }

    private static TreeNode bst(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int m = left + (right - left) / 2;

        TreeNode node = new TreeNode();
        node.val = nums[m];
        node.left = bst(nums, left, m - 1);
        node.right = bst(nums, m + 1, right);

        return node;


    }
}
