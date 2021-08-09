package one;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
//        root.setLeft(new TreeNode(4));
//        root.setRight(new TreeNode(6));
//        root.getRight().setLeft(new TreeNode(3));
//        root.getRight().setRight(new TreeNode(7));

        System.out.println(isValidBST(root));


    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return validate(root, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);


    }

    private static boolean validate(TreeNode root, float minValue, float maxValue) {

        if (root == null) {
            return true;
        }

        return root.val > minValue && root.val < maxValue && validate(root.left, minValue, root.val) && validate(root.right, root.val, maxValue);

    }
}
