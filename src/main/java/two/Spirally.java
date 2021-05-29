package two;

import java.util.ArrayList;

public class Spirally {
    public static void main(String[] args) {
        int matrix[][] = {  {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}
                         };
        spirallyTraverse(matrix, matrix.length, matrix[0].length);
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> f = new ArrayList<>();

        int k = 0;
        int l = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
//                f.add(  )
            }
        }

        return null;
    }
}
