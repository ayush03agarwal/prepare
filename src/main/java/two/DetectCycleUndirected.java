package two;

import java.util.*;

public class DetectCycleUndirected {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(4);
        adj.add(a);


        a = new ArrayList<>();
        a.add(3);
        a.add(2);
//        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
        a.add(1);
        a.add(3);
        adj.add(a);

        a = new ArrayList<>();
        a.add(1);
        a.add(2);
        adj.add(a);

        a = new ArrayList<>();
//        a.add(0);
//        a.add(3);
//        adj.add(a);
        System.out.println(isCycle(adj.size(), adj));
    }

    static boolean f = true;

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean arr[] = new boolean[adj.size()];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < V; i++) {
            if (!arr[i]) {
                arr[i] = true;
                m.put(i, -1);
                f = f && isCycle(i, adj, arr, m, -1);
            }
        }
        return !f;
    }

    private static boolean isCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] arr, Map<Integer, Integer> m, int parent) {
        ArrayList<Integer> a = adj.get(i);
        for (int k : a) {
            if (!arr[k]) {
                arr[k] = true;
                m.put(k, i);
                return f && isCycle(k, adj, arr, m, i);
            } else if (k != parent) {
                return false;
            }
        }
        return true;
    }
}
