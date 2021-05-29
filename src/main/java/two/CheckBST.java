package two;

public class CheckBST {

    public static void main(String[] args) {
        TNode t = new TNode(1);
        t.left = new TNode(0);
        t.right = new TNode(3);

        System.out.println(isBST(t));

    }

    static boolean isBST(TNode root) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return checkBST(root, min, max);
    }

    private static boolean checkBST(TNode root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.data > min && root.data < max) {
            return checkBST(root.left, min, root.data)
                    && checkBST(root.right, root.data, max);
        }
        return false;
    }

}
