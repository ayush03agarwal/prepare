package one;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
        System.out.println(board);
    }

    public static void gameOfLife(int[][] board) {

        // 0  0  0
        // 1  1  1
        // 1  0  2
        // 0  1  3

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int c = countNeighbour(i, j, board);


                if (board[i][j] == 1) {
                    if (c == 2 || c == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 2;
                    }
                } else {
                    if (c == 3) {
                        board[i][j] = 3;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }


    }

    private static int countNeighbour(int r, int c, int[][] board) {
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[r].length || (r == i && c == j)) {
                    continue;
                } else {
                    if (board[i][j] == 1 || board[i][j] == 2) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
