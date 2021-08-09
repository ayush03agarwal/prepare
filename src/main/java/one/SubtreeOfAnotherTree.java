package one;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(5));
//
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(2));

//
        TreeNode root2 = new TreeNode(1);
//        root2.setLeft(new TreeNode(1));
//        root2.setRight(new TreeNode(2));


        System.out.println(isSubtree(root, root2));

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        } else if (isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
        }
    }

    private static boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }

        if (node == null || subRoot == null) {
            return false;
        }

        if (node.val == subRoot.val) {
            return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
        }

        return false;
    }
}
