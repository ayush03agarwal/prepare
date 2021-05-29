package two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] g = new int[][]{{2, 2, 0, 1}};
        System.out.println(orangesRotting(g));
    }

    public static int orangesRotting(int[][] grid) {

        Queue<Integer> q = new LinkedList<>();


        System.out.println(Arrays.toString(grid));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {

                    int k = i - 1;
                    int l = i + 1;
                    int m = j + 1;
                    int n = j - 1;

                    if (k >= 0 && k < grid.length) {
                        grid[k][j] = 2;
                    }

                    if (l >= 0 && l < grid.length) {
                        grid[l][j] = 2;
                    }


                    if (m >= 0 && m < grid[m].length) {
                        grid[i][m] = 2;
                    }

                    if (n >= 0 && n < grid[n].length) {
                        grid[i][n] = 2;
                    }
                }

            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return 1;


    }
}
