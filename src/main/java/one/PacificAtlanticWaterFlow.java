package one;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {

        int[][] height = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        List<List<Integer>> lists = pacificAtlantic(height);
        System.out.println(lists);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> f = new ArrayList<>();
        int[][] mat = new int[heights.length][heights[0].length];

        checkPacific(heights, mat);
        checkAtlantic(heights, mat);

        System.out.println(mat);
        return null;

    }

    // 1 means pacific
    private static void checkPacific(int[][] heights, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 1;
                    continue;
                }
                int up = i - 1;
                int left = j - 1;

                if (up < 0 || left < 0) {
                    continue;
                }

                if ((heights[i][j] >= heights[up][j] && mat[up][j] == 1)
                        ||
                        (heights[i][j] >= heights[i][left] && mat[i][left] == 1)) {
                    mat[i][j] = 1;
                }
            }
        }
    }

    // 1 means pacific
    private static void checkAtlantic(int[][] heights, int[][] mat) {
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (i == mat.length - 1 || j == mat[0].length - 1) {
                    if (mat[i][j] == 1) {
                        mat[i][j] = 3;
                    } else {
                        mat[i][j] = 2;
                    }
                    continue;
                }
                int down = i + 1;
                int right = j + 1;

                if (down >= heights.length || right >= heights[0].length) {
                    continue;
                }

                if ((heights[i][j] >= heights[down][j] && mat[down][j] == 2)
                        ||
                        (heights[i][j] <= heights[i][right] && mat[i][right] == 2)) {
                    mat[i][j] = 2;
                } else if ((heights[i][j] >= heights[down][j] && mat[down][j] == 3)
                        ||
                        (heights[i][j] <= heights[i][right] && mat[i][right] == 3)) {
                    mat[i][j] = 3;
                }


            }
        }
    }
}
