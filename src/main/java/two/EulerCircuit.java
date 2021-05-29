package two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EulerCircuit {


    int V;
    List<List<Integer>> adj;
    int[] in;
    static final int CHARS = 26;

    EulerCircuit(int V) {
        this.V = V;
        in = new int[V];
        adj = new ArrayList<>(CHARS);

        for (int i = 0; i < CHARS; i++) {
            adj.add(i, new ArrayList<>());
        }

    }


    void addEdge(int v, int w) {
        adj.get(v).add(w);
        in[w]++;
    }

    boolean isEulerianCycle() {

        if (!isSC()) {
            return false;
        }

        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() != in[i]) {
                return false;
            }
        }
        return true;

    }

    boolean isSC() {

        boolean arr[] = new boolean[V];

        int n;
        for (n = 0; n < V; n++) {
            if (adj.get(n).size() > 0) {
                break;
            }
        }

        DFSUtil(n, arr);


        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() > 0 && !arr[i]) {
                return false;
            }
        }

        EulerCircuit gr = getTranspose();
        arr = new boolean[V];


        gr.DFSUtil(n, arr);

        for (int i = 0; i < V; i++)
            if (adj.get(i).size() > 0 && !arr[i])
                return false;

        return true;

    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (Integer i : adj.get(v)) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    EulerCircuit getTranspose(){
        EulerCircuit g = new EulerCircuit(V);

        return null;

    }


}
