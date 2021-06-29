package two;

public class PopulateInorderSuccessor {

    public static void main(String[] args) {

        TNode node = new TNode(10);
        node.left = new TNode(8);
        node.right = new TNode(12);
        node.left.left = new TNode(3);
        node.left.right = new TNode(6);
        node.right.left = new TNode(13);
        node.right.right = new TNode(14);

        populateNext(node);

        System.out.println(node);

    }

    // 3 , 8, 6, 10 , 13, 12 , 14

    static TNode prev = null;

    public static void populateNext(TNode node) {
        if (node == null) {
            return;
        }
        populateNext(node.left);
        if (prev != null) {
            prev.nextRight = node;
        }
        prev = node;
        populateNext(node.right);
    }


}
