package two;

import java.util.ArrayList;
import java.util.Stack;

public class DetectCycleDirected {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        adj.add(a);


        a = new ArrayList<>();
        a.add(2);
        adj.add(a);

        a = new ArrayList<>();
        a.add(3);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        a = new ArrayList<>();
//        a.add(0);
//        a.add(2);
//        adj.add(a);
        System.out.println(isCycle(adj.size(), adj));
    }


    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean arr[] = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!arr[i]) {
                s = new Stack<>();
                s.add(i);
                arr[i] = true;
                hasNoCycle(i, adj, arr, s);
            }
        }
        return !f;
    }

    static boolean f = true;

    private static void hasNoCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] arr, Stack<Integer> s) {
        ArrayList<Integer> l = adj.get(i);
        for (int k : l) {
            if (!arr[k]) {
                arr[k] = true;
                s.add(k);
                hasNoCycle(k, adj, arr, s);
                s.pop();
            } else {
                if (s.contains(k)) {
                    f = false;
                }
            }
        }
    }
}
