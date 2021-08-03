package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
        boolean pac[][] = new boolean[heights.length][heights[0].length];
        boolean atl[][] = new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();

        int row = heights.length;
        int col = heights[0].length;

        //DFS
        for (int i = 0; i < col; i++) {
            dfs(heights, pac, 0, i, Integer.MIN_VALUE);
            dfs(heights, atl, row - 1, i, Integer.MIN_VALUE);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, pac, i, 0, Integer.MIN_VALUE);
            dfs(heights, atl, i, col - 1, Integer.MIN_VALUE);
        }


        //Result
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;

    }

    private static void dfs(int[][] height, boolean[][] ocean, int i, int j, int prev) {
        if (i < 0 || i >= height.length || j < 0 || j >= height[0].length) {
            return;
        }

        if (height[i][j] < prev || ocean[i][j]) {
            return;
        }

        ocean[i][j] = true;

        for (int[] d : dir) {
            dfs(height, ocean, i + d[0], j + d[1], height[i][j]);
        }
    }
}
