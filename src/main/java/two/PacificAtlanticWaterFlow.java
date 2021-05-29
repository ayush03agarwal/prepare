package two;

import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {

        int m[][] = new int[5][5];
        int n[] = new int[]{1, 2, 2, 3, 5};
        m[0] = n;
        n = new int[]{3, 2, 3, 4, 4};
        m[1] = n;
        n = new int[]{2, 4, 5, 3, 1};
        m[2] = n;

        n = new int[]{6, 7, 1, 4, 5};
        m[3] = n;
        n = new int[]{5, 1, 1, 2, 4};
        m[4] = n;
        System.out.println(pacificAtlantic(m));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        String p[][] = new String[matrix.length][matrix.length];
        String a[][] = new String[matrix.length][matrix.length];
        String b[][] = new String[matrix.length][matrix.length];


        for (int i = 0; i < matrix.length; i++) {
            p[0][i] = "p";
        }
        for (int i = 0; i < matrix.length; i++) {
            p[i][0] = "p";
        }

        for (int i = 0; i < matrix.length; i++) {
            a[i][matrix.length - 1] = "a";
        }
        for (int i = 0; i < matrix.length; i++) {
            a[matrix.length - 1][i] = "a";
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (p[i][j].equals("p")
                        && a[i][j].equals("a")) {
                    b[i][j] = "b";
                }
            }
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {

                //Pacific
                int up = j - 1;
                int left = i - 1;

                if (matrix[i][j] >= matrix[i][up]) {
                    b[i][j] = p[i][up];
                }
                if (b[i][j] == null) {
                    if (matrix[i][j] >= matrix[left][j]) {
                        b[i][j] = p[left][j];
                    }
                }


                // Atlantic
                int down = j + 1;
                int right = i + 1;


                if (matrix[i][j] >= matrix[i][down]) {
                    b[i][j] = p[i][up];
                }

                if (b[i][j] == null) {
                    if (matrix[i][j] >= matrix[left][j]) {
                        b[i][j] = p[left][j];
                    }
                }


                while (down < matrix.length) {
                    if (b[i][j] == null && b[down][j] != null) {
                        b[i][j] = b[down][j];
                    }
                    down++;
                }


            }
        }
        return null;
    }
}
