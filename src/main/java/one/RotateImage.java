package one;

public class RotateImage {
    public static void main(String[] args) {
        int[][] height = {{1, 2, 2, 3, 5},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        rotate(height);
        System.out.println("dfa");
    }

    public static void rotate(int[][] matrix) {
        int[][] result = new int[matrix[0].length - 1][matrix.length - 1];

        int x = 0;
        int y = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {


            }
        }


    }
}
