package one;

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    TopologicalSort(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
        visited = new boolean[V];
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSortImpl(int vertex) {
        ArrayList<Integer> integers = adj.get(vertex);
        for (int i : integers) {
            if (!visited[i]) {
                visited[i] = true;
                topologicalSortImpl(i);
                stack.push(i);
            }
        }
        if (!visited[vertex]) {
            visited[vertex] = true;
            stack.push(vertex);
        }
    }

    void topologicalSort() {
        for (int i = 0; i < V; i++) {
            topologicalSortImpl(i);
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    public static void main(String args[]) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological "
                + "sort of the given graph");
        g.topologicalSort();
    }
}
