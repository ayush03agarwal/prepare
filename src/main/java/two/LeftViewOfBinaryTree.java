package two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    public static void main(String[] args) {

        TNode t = new TNode(1);
        t.left = new TNode(2);
        t.right = new TNode(3);


        t.left.left = new TNode(4);
        t.left.right = new TNode(5);

        t.right.left = new TNode(6);
        t.right.right = new TNode(7);

        t.left.left.left = new TNode(8);

        System.out.println(leftView(t));
    }

    static ArrayList<Integer> leftView(TNode root) {


        ArrayList<Integer> a = new ArrayList<>();
        Queue<TNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int c = 0;
        while (!q.isEmpty()) {
            TNode n = q.poll();
            if (c == 0 && n != null) {
                a.add(n.data);
            }
            if (n != null && n.left != null) {
                q.add(n.left);
            }
            if (n != null && n.right != null) {
                q.add(n.right);
            }
            c++;
            if (n == null) {
                c = 0;
                if (!q.isEmpty())
                    q.add(null);
            }
        }


        return a;

    }


}


class TNode {
    int data;
    TNode left, right, nextRight;

    TNode(int item) {
        data = item;
        left = right = nextRight = null;
    }
}