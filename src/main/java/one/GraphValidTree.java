package one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphValidTree {


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        System.out.println(validTree(5, edges));
    }

    public static boolean validTree(int n, int[][] edges) {

        boolean t = edges.length == n - 1;
        boolean[] visited = new boolean[n];
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> orDefault0 = m.getOrDefault(edges[i][0], new ArrayList<>());
            orDefault0.add(edges[i][1]);
            m.put(edges[i][0], orDefault0);
            ArrayList<Integer> orDefault1 = m.getOrDefault(edges[i][1], new ArrayList<>());
            orDefault1.add(edges[i][0]);
            m.put(edges[i][1], orDefault1);
        }


        dfs(m, visited, 0);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return t;
    }

    private static void dfs(Map<Integer, ArrayList<Integer>> m, boolean[] visited, int i) {

        if (visited[i]) {
            return;
        }


        visited[i] = true;

        ArrayList<Integer> l = m.get(i);
        if (l != null) {
            for (int n : l) {
                dfs(m, visited, n);
            }
        }


    }
}
