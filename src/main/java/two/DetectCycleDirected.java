package two;

import java.util.ArrayList;

public class DetectCycleDirected {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        adj.add(a);


        a = new ArrayList<>();
        adj.add(a);

        a = new ArrayList<>();
        a.add(3);
        a.add(1);
        adj.add(a);

        a = new ArrayList<>();
        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        a.add(2);
        adj.add(a);
        System.out.println(isCycle(adj.size(), adj));
    }


    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[];

        for (int i = 0; i < V; i++) {
            visited = new boolean[V];
            boolean t = hasCycle(i, adj, visited);
            if (t) {
                return true;
            }
        }

        return false;

    }

    private static boolean hasCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        if (visited[i]) {
            return true;
        }
        visited[i] = true;

        ArrayList<Integer> a = adj.get(i);
        for (int j : a) {
            boolean t = hasCycle(j, adj, visited);
            if (t) {
                return true;
            }
        }

        visited[i] = false;

        return false;

    }


}
