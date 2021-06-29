package two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TNode t = new TNode(1);
        t.left = new TNode(2);
        t.right = new TNode(3);


        t.left.left = new TNode(4);
        t.left.right = new TNode(5);

        t.right.left = new TNode(6);
        t.right.right = new TNode(7);
        t.right.right.right = new TNode(9);


        System.out.println(LCA(t, 4, 10).data);
    }

    static TNode LCA(TNode root, int n1, int n2) {

        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        TNode l = LCA(root.left, n1, n2);
        TNode r = LCA(root.right, n1, n2);

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l : r;

    }

}
