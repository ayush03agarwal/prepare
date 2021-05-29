package two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Spiral {

    public static void main(String[] args) {
        TNode t = new TNode(1);
        t.left = new TNode(2);
        t.right = new TNode(3);


        t.left.left = new TNode(4);
        t.left.right = new TNode(5);

        t.right.left = new TNode(6);
        t.right.right = new TNode(7);


        System.out.println(findSpiral(t));
    }

    static ArrayList<Integer> findSpiral(TNode root) {
        ArrayList<Integer> a = new ArrayList<>();
        Stack<TNode> q1 = new Stack<>();
        Stack<TNode> q2 = new Stack<>();

        q1.add(root);

        findSpiral(q1, q2, a);

        return a;
    }

    private static void findSpiral(Stack<TNode> q1, Stack<TNode> q2, ArrayList<Integer> a) {

        if (!q1.isEmpty()) {

            while (!q1.isEmpty()) {

                TNode pop = q1.pop();
                a.add(pop.data);

                if (pop.right != null) {
                    q2.add(pop.right);
                }
                if (pop.left != null) {
                    q2.add(pop.left);
                }
            }
        }
        if (!q2.isEmpty()) {

            while (!q2.isEmpty()) {

                TNode pop = q2.pop();
                a.add(pop.data);

                if (pop.left != null) {
                    q1.add(pop.left);
                }
                if (pop.right != null) {
                    q1.add(pop.right);
                }
            }

            findSpiral(q1, q2, a);
        }


    }
}
