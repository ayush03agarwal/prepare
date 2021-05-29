package two;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalTraversalBT {
    public static void main(String[] args) {


        TNode t = new TNode(1);
        t.left = new TNode(2);
        t.right = new TNode(3);


        t.left.left = new TNode(4);
        t.left.right = new TNode(5);

        t.right.right = new TNode(6);


        System.out.println(verticalOrder(t));

    }

    static ArrayList<Integer> verticalOrder(TNode root) {
        TreeMap<Integer, List> m = new TreeMap<>();
        verticalOrder(root, 0, m);
        ArrayList<Integer> f = new ArrayList<>();
        for (List<Integer> l : m.values()) {
            f.addAll(l);
        }
        return f;
    }

    static void verticalOrder(TNode n, int d, TreeMap<Integer, List> m) {

        if (n == null) {
            return;
        }

        List<Integer> list = m.get(d);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(n.data);
        m.put(d, list);

        verticalOrder(n.left, d - 1, m);
        verticalOrder(n.right, d + 1, m);


    }


}
