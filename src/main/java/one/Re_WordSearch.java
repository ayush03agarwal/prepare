package one;

public class Re_WordSearch {
    public static void main(String[] args) {

        char[][] b = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(b, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean t = dfs(board, word, 0, i, j, visited);
                if (t) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int at, int i, int j, boolean[][] visited) {

        if (at == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(at) != board[i][j]) {
            return false;
        }


        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        visited[i][j] = true;

        for (int k = 0; k < dir.length; k++) {

            int i1 = i + dir[k][0];
            int j1 = j + dir[k][1];

            boolean res = dfs(board, word, at + 1, i1, j1, visited);
            if (res) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;

    }
}
