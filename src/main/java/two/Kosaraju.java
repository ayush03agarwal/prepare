package two;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        adj.add(a);

        a = new ArrayList<>();
        a.add(2);
        adj.add(a);

        a = new ArrayList<>();
        a.add(3);
        adj.add(a);

        a = new ArrayList<>();
        a.add(4);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        System.out.println(kosaraju(adj.size(), adj));
    }

    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean arr[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!arr[i]) {
                arr[i] = true;
                dfs(i, s, arr, adj);
                s.push(i);
            }
        }


        ArrayList<ArrayList<Integer>> rev = reverse(adj);

        arr = new boolean[V];

        int c = 0;
        while (!s.isEmpty()) {
            int i = s.pop();
            if (!arr[i]) {
                arr[i] = true;
                dfs(i, arr, rev);
                c++;
            }
        }
        return c;
    }

    private static ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj) {

        int c = 0;
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> a = new ArrayList<>();
            rev.add(a);
        }

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> a = adj.get(i);
            for (int k : a) {
                ArrayList<Integer> ar = rev.get(k);
                ar.add(i);
            }

        }
        return rev;
    }


    private static void dfs(int i, boolean[] arr, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> a = adj.get(i);
        for (int k : a) {
            if (!arr[k]) {
                arr[k] = true;
                dfs(k, arr, adj);

            }
        }
    }


    private static void dfs(int i, Stack<Integer> s, boolean[] arr, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> a = adj.get(i);
        for (int k : a) {
            if (!arr[k]) {
                arr[k] = true;
                dfs(k, s, arr, adj);
                s.push(k);

            }
        }
    }
}
