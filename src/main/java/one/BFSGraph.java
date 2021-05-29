package one;

import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    private int V;

    private LinkedList<Integer> adj[];
    private Queue<Integer> q;
    private boolean visited[];

    @SuppressWarnings("unchecked")
    BFSGraph(int v) {
        V = v;
        visited = new boolean[V];
        adj = new LinkedList[v];
        q = new LinkedList<Integer>();
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public static void main(String args[]) {
        BFSGraph g = new BFSGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breath First Traversal " +
                "(starting from vertex 2)");
        g.BFS(2);
    }

    private void BFS(int start) {
        LinkedList<Integer> integers = adj[start];
        visited[start] = true;
        System.out.println(start);
        for (int i : integers) {
            if (!visited[i]) {
                q.add(i);
            }
        }
        if (!q.isEmpty())
            BFS(q.remove());
    }
}
