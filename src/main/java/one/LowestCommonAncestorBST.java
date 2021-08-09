package one;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
//        root.setRight(new TreeNode(8));
//
//        root.getLeft().setLeft(new TreeNode(0));
//        root.getLeft().setRight(new TreeNode(4));
//
//        root.getLeft().getRight().setLeft(new TreeNode(3));
//        root.getLeft().getRight().setRight(new TreeNode(5));
//
//        root.getRight().setLeft(new TreeNode(7));
//        root.getRight().setRight(new TreeNode(9));
//
//
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        TreeNode node = lowestCommonAncestor(root, p, q);
        System.out.println(node);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        return lca(root, p, q);

    }

    private static TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return null;
        }
        if (node.val >= p.val && node.val <= q.val) {
            return node;
        }

        if (node.val > p.val && node.val > q.val) {
            return lca(node.left, p, q);
        }

        if (node.val < p.val && node.val < q.val) {
            return lca(node.right, p, q);
        }
        return null;
    }
}
