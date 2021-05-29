package two;

public class NumberOfIslands {
    public static void main(String[] args) {

        char mat[][] = {{0, 1, 0},
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 1},
                {1, 1, 1},
                {0, 1, 1},
                {1, 0, 1}};

        System.out.println(numIslands(mat));
    }


    public static int numIslands(char[][] grid) {

        boolean arr[][] = new boolean[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            arr[i] = new boolean[grid[i].length];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !arr[i][j]) {
                    numIslands(i, j, grid, arr);
                    c++;
                }
            }
        }
        return c;
    }

    static int c = 0;

    private static void numIslands(int i, int j, char[][] grid, boolean[][] arr) {
        if (i < grid.length
                && i >= 0
                && j < grid[i].length
                && j >= 0
                && !arr[i][j]
                && grid[i][j] == 1) {
            arr[i][j] = true;
            numIslands(i - 1, j, grid, arr);
            numIslands(i + 1, j, grid, arr);
            numIslands(i, j - 1, grid, arr);
            numIslands(i, j + 1, grid, arr);
            numIslands(i + 1, j + 1, grid, arr);
            numIslands(i - 1, j - 1, grid, arr);
            numIslands(i - 1, j + 1, grid, arr);
            numIslands(i + 1, j - 1, grid, arr);
        }


    }
}
