package one;

public class RotateImage2 {
    public static void main(String[] args) {
        int[][] height = {{1, 2, 2, 3, 5},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        rotate(height);
        System.out.println("dfa");
    }

    public static void rotate(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int k = matrix.length - 1 - i;
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][k] = matrix[i][j];
            }
        }

        System.out.println(result);
    }
}
