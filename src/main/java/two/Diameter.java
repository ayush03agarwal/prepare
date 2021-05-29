package two;

public class Diameter {

    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {

        TNode t1 = new TNode(3);
        t1.left = new TNode(4);
        t1.right = new TNode(5);

//        t1.left.left = new TNode(-10);
//        t1.left.right = new TNode(4);

        diameter(t1);
        System.out.println(res);
    }

    static int diameter(TNode root) {

        d(root);
        return res;
    }

    static int d(TNode root) {
        if (root == null) {
            return 0;
        }

        int l = diameter(root.left);
        int r = diameter(root.right);

        res = Math.max(res, 1 + l + r);
        return Math.max(l, r) + 1;
    }
}
