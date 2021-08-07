package one;

public class RotateImage {
    public static void main(String[] args) {
        int[][] height = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(height);
        System.out.println("dfa");
    }

    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }


        System.out.println(matrix);


    }
}
