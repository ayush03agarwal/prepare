package two;

import one.Graph;

import java.util.Iterator;

public class Bipartite {

    static boolean f = true;

    public static void main(String[] args) {

        Graph g = new Graph(7);

        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(4, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 2);
        g.addEdge(5, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(6, 3);


        int[] visited = new int[7];
        int color = 1;
        bipartite(1, -1, g, color, visited);
        System.out.println(f);

    }


    public static void bipartite(int v, int p, Graph g, int color, int[] visited) {
        visited[v] = color;
        for (int i : g.adj[v]) {
            if (visited[i] == 0) {
                color = 3 - visited[v];
                visited[i] = color;
                bipartite(i, v, g, color, visited);
            } else if (p != i && visited[v] == color) {
                f = false;
            }
        }

    }

}
