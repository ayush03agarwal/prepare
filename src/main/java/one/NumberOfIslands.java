package one;

public class NumberOfIslands {


    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}

        };


        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {


        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == '2') {
                    continue;
                }
                dfs(grid, i, j);
                count++;
            }
        }

        return count;

    }

    private static void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '2') {
            return;
        }

        grid[i][j] = '2';
        for (int[] d : dir) {
            int i1 = i + d[0];
            int j1 = j + d[1];
            dfs(grid, i1, j1);
        }


    }
}
