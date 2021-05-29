package two;

public class TwoTreesIdentical {
    public static void main(String[] args) {

        TNode t1 = new TNode(10);
        t1.left = new TNode(12);
        t1.right = new TNode(15);

        TNode t2 = new TNode(10);
        t2.left = new TNode(15);
        t2.right = new TNode(15);
        System.out.println(isIdentical(t1, t2));
    }

    static boolean isIdentical(TNode root1, TNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }


        boolean l = isIdentical(root1.left, root2.left);
        boolean r = isIdentical(root1.right, root2.right);

        return l && r;
    }
}
