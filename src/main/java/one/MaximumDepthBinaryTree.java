package one;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.setLeft(new TreeNode(13));
        root.setRight(new TreeNode(10));

        root.getRight().setLeft(new TreeNode(14));
        root.getRight().setRight(new TreeNode(15));

        root.getRight().getLeft().setLeft(new TreeNode(21));
        root.getRight().getLeft().setRight(new TreeNode(24));

        root.getRight().getRight().setLeft(new TreeNode(22));
        root.getRight().getRight().setRight(new TreeNode(23));


        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int d = depth(root);
        return d;
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }


        int l = depth(node.getLeft());
        int r = depth(node.getRight());

        return 1 + Math.max(l, r);


    }


}
