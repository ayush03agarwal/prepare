package one;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void main(String[] args) {

        char[][] b = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(b, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {


        List<int[]> starts = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    starts.add(new int[]{i, j});
                }
            }
        }

        for (int[] s : starts) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            boolean t = dfs(visited, word, s[0], s[1], board);
            if (t) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(boolean[][] visited, String word, int i, int j, char[][] board) {

        if (word.isEmpty()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }


        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        visited[i][j] = true;

        if (board[i][j] == word.charAt(0)) {
            word = word.substring(1);
            if (word.isEmpty()) {
                return true;
            }
        }

        for (int k = 0; k < dir.length; k++) {

            int i1 = i + dir[k][0];
            int j1 = j + dir[k][1];

            if (!(i1 < 0 || j1 < 0 || i1 >= board.length || j1 >= board[0].length || visited[i1][j1]) && board[i1][j1] == word.charAt(0)) {
                boolean t = dfs(visited, word, i1, j1, board);
                if (t) {
                    return true;
                }
            }
        }
        visited[i][j] = false;

        return false;
    }
}
