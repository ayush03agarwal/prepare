package one;

public class LongestIncreasingPathMatrix {

    static int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

        int matrix[][] = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        System.out.println(longestIncreasingPath(matrix));

    }

    public static int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 1 && matrix[0].length == 1) {
            return 1;
        }

        int max = 0;

        int maxMat[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int l = getMaxLen(i, j, matrix, maxMat);
                max = Math.max(max, l);
            }
        }
        return max;
    }

    private static int getMaxLen(int i, int j, int[][] matrix, int[][] maxMat) {
        if (i >= matrix.length || i < 0 || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        if (maxMat[i][j] > 0) {
            return maxMat[i][j];
        }

        int max = 0;
        for (int d = 0; d < dir.length; d++) {
            int newi = i + dir[d][0];
            int newj = j + dir[d][1];
            if (newi >= matrix.length || newi < 0 || newj < 0 || newj >= matrix[0].length) {
                continue;
            }
            if (matrix[i][j] < matrix[newi][newj]) {
                int l = getMaxLen(newi, newj, matrix, maxMat);
                max = Math.max(max, l);
            }
        }
        maxMat[i][j] = max + 1;
        return max + 1;

    }
}
