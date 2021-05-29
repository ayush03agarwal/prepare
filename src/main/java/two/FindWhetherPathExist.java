package two;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

public class FindWhetherPathExist {
    public static void main(String[] args) {
        int matrix[][] = {  {0, 3, 0, 1},
                            {3, 0, 0, 3},
                            {2, 0, 3, 3},
                            {0, 3, 3, 3}};

        // calling isPath method
        System.out.println(isPath(matrix, 4));
    }


    public static boolean isPath(int matrix[][], int n) {
        boolean arr[][] = new boolean[n][n];
        boolean f = false;
        Pnt src = null;
        Pnt dest = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    src = new Pnt(i, j);
                } else if (matrix[i][j] == 2) {
                    dest = new Pnt(i, j);
                }
            }
        }

        Queue<Pnt> q = new LinkedList<>();
        q.add(src);
        int rowNum[] = {-1, 1, 0, 0};
        int colNum[] = {0, 0, 1, -1};


        while (!q.isEmpty()) {

            Pnt p = q.peek();


            q.remove();

            for (int k = 0; k < 4; k++) {

                int row = rowNum[k] + p.x;
                int col = colNum[k] + p.y;

                if (row == dest.x && col == dest.y) {
                    f = true;
                    q.clear();
                }

                if (!(row < 0
                        || row >= matrix.length
                        || col < 0
                        || col >= matrix[row].length
                        || arr[row][col]
                        || matrix[row][col] == 3)) {
                    arr[row][col] = true;
                    q.add(new Pnt(row, col));
                }


            }


        }
        return f;

    }
}
