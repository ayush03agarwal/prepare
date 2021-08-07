package one;

public class BinaryTreeMaximumPathSum {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
//
        root.getLeft().setLeft(new TreeNode(-3));
        root.getLeft().setRight(new TreeNode(-2));

        root.getLeft().getLeft().setLeft(new TreeNode(-1));
        root.getLeft().getLeft().setRight(new TreeNode(-1));

        root.getRight().getRight().setLeft(new TreeNode(22));
//        root.getRight().getRight().setRight(new TreeNode(23));
//

        System.out.println(maxPathSum(root));
        System.out.println("sdfad");
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxSum(root);
        return max;

    }

    private static int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = maxSum(node.left);
        int r = maxSum(node.right);

        int maxStraight = Math.max(Math.max(l, r) + node.val, node.val);
        int maxCaseVal = Math.max(node.val + l + r, maxStraight);

        max = Math.max(max, maxCaseVal);


        return maxStraight;
    }


}
