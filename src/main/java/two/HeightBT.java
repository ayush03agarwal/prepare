package two;

public class HeightBT {
    public static void main(String[] args) {

        TNode t1 = new TNode(10);
        t1.left = new TNode(12);
        t1.right = new TNode(12);

        t1.left.left = new TNode(13);
        t1.left.left.left = new TNode(13);


        System.out.println(height(t1));
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
