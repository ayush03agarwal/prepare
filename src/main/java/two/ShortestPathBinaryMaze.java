package two;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMaze {

    public static void main(String[] args) {

        int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        System.out.println(shortestDistance(mat.length, mat[0].length, mat, 3, 4));

    }

    static int shortestDistance(int N, int M, int A[][], int X, int Y) {

        int f = 0;

        int rowNum[] = {-1, 1, 0, 0};
        int colNum[] = {0, 0, 1, -1};


        boolean arr[][] = new boolean[N][M];
        Queue<Pnt> q = new LinkedList<>();
        q.add(new Pnt(0, 0, 0));
        arr[0][0] = true;

        if (A[0][0] == 0) {
            return -1;
        }


        while (!q.isEmpty()) {
            Pnt p = q.peek();
            q.remove();

            if (p.x == X && p.y == Y) {
                f = p.dist;
                q.clear();
            }

            for (int n = 0; n < 4; n++) {
                int row = rowNum[n] + p.x;
                int col = colNum[n] + p.y;
                if (!(row >= A.length
                        || row < 0
                        || col >= A[n].length
                        || col < 0
                        || arr[row][col]
                        || A[row][col] == 0)) {
                    arr[row][col] = true;
                    q.add(new Pnt(row, col, A[row][col] + p.dist));
                }
            }
        }
        return f;
    }
}

@Data
@AllArgsConstructor
class Pnt {

    Pnt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
    int dist;
}
