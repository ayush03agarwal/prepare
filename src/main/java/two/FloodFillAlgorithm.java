package two;

import java.util.Arrays;

public class FloodFillAlgorithm {


    static int prev = -1;

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        int x = 1, y = 1, newC = 2;
        prev = screen[x][y];
        int[][] a = floodFill(screen, x, y, newC);

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (sr >= image.length
                || sr < 0
                || sc < 0
                || sc >= image[sr].length
                || image[sr][sc] != prev) {
            return image;
        }


        image[sr][sc] = newColor;

        floodFill(image, sr + 1, sc, newColor);
        floodFill(image, sr - 1, sc, newColor);
        floodFill(image, sr, sc + 1, newColor);
        floodFill(image, sr, sc - 1, newColor);


        return image;
    }
}
