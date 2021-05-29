package two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        adj.add(a);


        a = new ArrayList<>();
        adj.add(a);

        a = new ArrayList<>();
        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
        adj.add(a);

        a = new ArrayList<>();
        adj.add(a);
        System.out.println(bfsOfGraph(adj.size(), adj));
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean arr[] = new boolean[adj.size()];
        ArrayList<Integer> a = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        bfs(adj, arr, a, q);
        return a;

    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] arr, ArrayList<Integer> a, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int c = q.poll();
            if (!arr[c]) {
                arr[c] = true;
                a.add(c);
                ArrayList<Integer> ka = adj.get(c);
                q.addAll(ka);
                bfs(adj, arr, a, q);
            }
        }
    }
}