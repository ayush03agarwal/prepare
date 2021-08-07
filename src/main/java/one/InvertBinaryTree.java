package one;

public class InvertBinaryTree {


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

        System.out.println(invertTree(root));
        System.out.println("dfadf");

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode n1 = invert(root);

        return n1;

    }

    private static TreeNode invert(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode l = invert(node.left);
        TreeNode r = invert(node.right);

        node.left = r;
        node.right = l;

        return node;
    }


}
