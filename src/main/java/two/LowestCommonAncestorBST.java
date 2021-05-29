package two;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {

        TNode t = new TNode(5);
        t.left = new TNode(3);
        t.right = new TNode(6);

        t.left.left = new TNode(2);
        t.left.right = new TNode(4);

        t.right.right = new TNode(8);
        t.right.right.left = new TNode(7);
        t.right.right.right = new TNode(10);

        System.out.println(LCA(t, 6, 10).data);
    }

    static TNode LCA(TNode root, int n1, int n2) {
        TNode f = getNode(root, n1, n2);
        if (f != null && find(f, n1) && find(f, n2)) {
            return f;
        }
        return null;
    }

    private static boolean find(TNode f, int n1) {

        boolean t1 = false;

        TNode n = f;
        while (n != null) {

            if (n.data < n1) {
                n = n.right;
            } else if (n.data > n1) {
                n = n.left;
            } else {
                t1 = true;
                break;
            }
        }
        return t1;


    }

    private static TNode getNode(TNode root, int n1, int n2) {

        TNode f = null;
        TNode h = root;

        while (f == null) {
            if (h.data < n1 && h.data < n2) {
                h = h.right;
            } else if (h.data > n1 && h.data > n2) {
                h = h.left;
            } else {
                f = h;
            }
        }

        return f;
    }
}
