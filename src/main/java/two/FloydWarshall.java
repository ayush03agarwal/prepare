package two;

public class FloydWarshall {
    public static void main(String[] args) {

        int INF = 9999;

        int graph[][] = {{0, 5, INF, 10},
                        {INF, 0, 3, INF},
                        {INF, INF, 0, 1},
                        {INF, INF, INF, 0}
        };

        floydWarshall(graph);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(" " + graph[i][j]);
            }
            System.out.println();
        }

    }

    static void floydWarshall(int graph[][]) {


        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }


    }


}
