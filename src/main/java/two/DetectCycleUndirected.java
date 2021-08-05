package two;

import java.util.ArrayList;

public class DetectCycleUndirected {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
//        a.add(4);
        a.add(3);
        adj.add(a);


        a = new ArrayList<>();
        a.add(0);
        a.add(2);
        adj.add(a);

        a = new ArrayList<>();
        a.add(1);
        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
//        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
//        a.add(0);
//        a.add(3);
        a.add(2);
        adj.add(a);
        System.out.println(isCycle(adj.size(), adj));
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i]) {
                continue;
            }

            boolean t = dfs(adj, visited, i, -1);
            if (t) {
                return true;
            }
        }

        return false;


    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int num, int parent) {


        if (visited[num]) {
            return true;
        }

        visited[num] = true;

        ArrayList<Integer> a = adj.get(num);
        for (int b : a) {
            if (b != parent) {
                boolean t = dfs(adj, visited, b, num);
                if (t) {
                    return true;
                }
            }
        }

        return false;
    }
}
