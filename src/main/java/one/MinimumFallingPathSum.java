package one;

public class MinimumFallingPathSum {

    public static void main(String[] args) {

        int matrix[][] = {{10, -98, 44}, {-20, 65, 34}, {-100, -1, 74}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {

        int minScore[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            minScore[0][i] = matrix[0][i];
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int score = matrix[i][j];

                int left = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    left = minScore[i - 1][j - 1];
                }
                int mid = minScore[i - 1][j];
                int right = Integer.MAX_VALUE;
                if (j + 1 < matrix[0].length) {
                    right = minScore[i - 1][j + 1];
                }

                score += Math.min(Math.min(left, mid), right);

                minScore[i][j] = score;

            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(minScore[matrix.length - 1][i], min);
        }

        return min;
    }
}
