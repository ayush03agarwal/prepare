package two;

public class CheckBalancedTree {


    public static void main(String[] args) {

        TNode t = new TNode(1);
        t.left = new TNode(0);
        t.right = new TNode(3);


        t.left.right = new TNode(3);
        t.left.right.right = new TNode(3);

        System.out.println(isBalanced(t));
    }


    static boolean bst = true;

    static boolean isBalanced(TNode root) {

        if (root == null) {
            return true;
        }

        boolean lb = isBalanced(root.left);
        boolean rb = isBalanced(root.right);

        int l = height(root.left);
        int r = height(root.right);

        if (Math.abs(l - r) > 1) {
            return false;
        }

        return lb && rb;

    }


    static int height(TNode node) {
        if (node == null) {
            return 0;
        }

        int l = 1 + height(node.left);
        int r = 1 + height(node.right);

        return l > r ? l : r;

    }


}
