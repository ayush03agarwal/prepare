package two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        adj.add(a);


        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        a = new ArrayList<>();
        a.add(0);
        adj.add(a);

        a = new ArrayList<>();
//        a.add(2);
//        adj.add(a);
        System.out.println(Arrays.toString(topoSort(adj.size(), adj)));
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> s = new Stack<>();
        boolean arr[] = new boolean[V];
        int f[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (!arr[i]) {
                arr[i] = true;
                topoSort(i, adj, s, arr);
                s.add(i);
            }
        }
        int c = 0;
        while (!s.empty()) {
            f[c++] = s.pop();
        }
        return f;
    }


    static void topoSort(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s, boolean arr[]) {
        ArrayList<Integer> a = adj.get(i);

        for (int k : a) {
            if (!arr[k]) {
                arr[k] = true;
                topoSort(k, adj, s, arr);
                s.add(k);
            }
        }
    }


}
