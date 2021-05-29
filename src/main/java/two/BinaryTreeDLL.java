package two;

public class BinaryTreeDLL {

    public static void main(String[] args) {
        TNode t = new TNode(10);
        t.left = new TNode(12);
        t.right = new TNode(15);

        t.left.left = new TNode(25);
        t.left.right = new TNode(30);

        t.right.left = new TNode(36);

        bToDLL(t);
    }

    static TNode bToDLL(TNode root) {

        TNode head = bToDLL(root, null);
        return head;

    }

    private static TNode bToDLL(TNode root, TNode head) {

        TNode prev = null;

        if (root == null) {
            return null;
        }


        bToDLL(root.left, head);

        root.left.right = root;
        root.left.left = prev;

        bToDLL(root.right, head);

        root.right.left = root;
        root.right.left = prev;

        return root;


    }

}
