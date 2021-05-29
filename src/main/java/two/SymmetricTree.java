package two;

public class SymmetricTree {
    public static void main(String[] args) {

        TNode t1 = new TNode(10);
        t1.left = new TNode(12);
        t1.right = new TNode(12);


        t1.left.left = new TNode(13);
        t1.left.right = new TNode(14);

        t1.right.left = new TNode(13);
        t1.right.right = new TNode(14);
        System.out.println(isSymmetric(t1));


    }

    public static boolean isSymmetric(TNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TNode n1, TNode n2) {

        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null) {
            return false;
        }

        if (n2 == null) {
            return false;
        }


        if (n1.data != n2.data) {
            return false;
        }
        boolean l = isSymmetric(n1.left, n2.right);
        boolean r = isSymmetric(n1.right, n2.left);

        return l && r;

    }
}
