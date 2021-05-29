package two;

import java.util.*;
import java.util.stream.Collectors;

public class BottomViewOfBinaryTree {
    public static void main(String[] args) {

        TNode t = new TNode(2);
//        t.left = new TNode(14);
        t.right = new TNode(3);


//        t.left.left = new TNode(5);
//        t.left.right = new TNode(3);

        t.right.left = new TNode(4);
//        t.left.right.right = new TNode(14);

//        t.right.right = new TNode(25);


        System.out.println(bottomView(t));

    }

    public static ArrayList<Integer> bottomView(TNode root) {
        Map<Integer, TNode> m = new HashMap<>();
        Map<TNode, Integer> hm = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        bottomView(root, 0, 0, m, hm);

        System.out.println(m);

        Collection<TNode> values = m.values();
        for (TNode t : values) {
            a.add(t.data);
        }


        return a;
    }

    static void bottomView(TNode n, int d, int h, Map<Integer, TNode> m, Map<TNode, Integer> hm) {

        if (n == null) {
            return;
        }

        hm.put(n, h);

        if (m.get(d) != null && hm.get(m.get(d)) != null) {
            Integer ht = hm.get(m.get(d));
            if (ht < h) {
                m.put(d, n);
            }
        } else {
            m.put(d, n);
        }

        bottomView(n.left, d - 1, h + 1, m, hm);
        bottomView(n.right, d + 1, h + 1, m, hm);

    }


}
