package two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    public static void main(String[] args) {


        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        dijkstra(graph, 0);
    }

    static void dijkstra(int graph[][], int src) {

        int f[] = new int[graph.length];
        Set<Integer> s = new HashSet<>();

        f[0] = 0;
        for (int i = 1; i < graph.length; i++) {
            f[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < graph.length; i++) {
            int source = findMin(f, s);
            s.add(source);

            System.out.println("sddsd");
            for (int j = 0; j < graph.length; j++) {
                if (!s.contains(j) && j != source && graph[source][j] != 0) {
                    if (f[j] > f[source] + graph[source][j]) {
                        f[j] = f[source] + graph[source][j];
                    }
                }
            }
            System.out.println("fff");

        }
        System.out.println(f);

    }

    static int findMin(int f[], Set<Integer> s) {
        int m = -1;
        int c = Integer.MAX_VALUE;

        for (int i = 0; i < f.length; i++) {
            if (!s.contains(i) && f[i] < c) {
                m = i;
                c = f[i];
            }
        }
        return m;

    }
}
