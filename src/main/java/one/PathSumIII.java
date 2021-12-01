package one;

public class PathSumIII {

    static int count = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(5));
        root.setRight(new TreeNode(-3));

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);


        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);
        System.out.println(pathSum(root, 8));

    }

    public static int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        sum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;

    }

    private static int sum(TreeNode n, int sum) {
        if (n == null) {
            return 0;
        }

        if (n.val == sum) {
            count++;
        }

        sum(n.left, sum - n.val);
        sum(n.right, sum - n.val);


        return 0;
    }

}
