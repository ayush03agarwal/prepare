package one;

public class KthSmallestElementBST {
    static int kVal = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(6));

        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));

        root.getLeft().getLeft().setLeft(new TreeNode(2));

        System.out.println(kthSmallest(root, 6));

    }

    public static int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        kVal = k;
        return find(root);
    }

    private static int find(TreeNode root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int l = find(root.left);
        if (l != Integer.MIN_VALUE) {
            return l;
        }
        kVal--;

        if (kVal == 0) {
            return root.val;
        }

        int r = find(root.right);
        if (r != Integer.MIN_VALUE) {
            return r;
        }

        return r;

    }
}
