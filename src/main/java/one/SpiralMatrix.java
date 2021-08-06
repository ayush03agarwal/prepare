package one;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] height = {{1, 2, 2, 3, 5},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        spiralOrder(height);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int dir = 0;

        while (left <= right && top <= down) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            } else {
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if (dir == 4) {
                dir = 0;
            }
        }


        return result;

    }
}
