package two;

public class MaximumPathSumBT {

    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {

        TNode t1 = new TNode(3);
        t1.left = new TNode(4);
        t1.right = new TNode(5);

        t1.left.left = new TNode(-10);
        t1.left.right = new TNode(4);


        maxPathSum(t1);
        System.out.println(res);

    }

    static int maxPathSum(TNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }

        int l = maxPathSum(root.left);
        int r = maxPathSum(root.right);


        if (root.left != null && root.right != null) {

            res = Math.max(res, root.data + l + r);

            return Math.max(l, r) + root.data;

        }

        return root.left == null ? r + root.data : l + root.data;
    }


}
