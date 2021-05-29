package two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DFS {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        adj.add(a);


        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        a = new ArrayList<>();
        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        a.add(3);
        adj.add(a);

        System.out.println(dfsOfGraph(adj.size(), adj));
    }

    static public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] arr = new boolean[adj.size()];
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        arr[0] = true;
        dfs(0, adj, arr, a);
        return a;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] arr, ArrayList<Integer> a) {

        ArrayList<Integer> aa = adj.get(i);

        for (int j = 0; j < aa.size(); j++) {
            int cc = aa.get(j);
            if (!arr[cc]) {
                a.add(cc);
                arr[cc] = true;
                dfs(cc, adj, arr, a);
            }
        }


    }
}
