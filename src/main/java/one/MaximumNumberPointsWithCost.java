package one;

public class MaximumNumberPointsWithCost {
    public static void main(String[] args) {

        int p[][] = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        System.out.println(maxPoints(p));

    }

    public static long maxPoints(int[][] points) {

        long maxScore[][] = new long[points.length][points[0].length];

        for (int i = 0; i < points[0].length; i++) {
            maxScore[0][i] = points[0][i];
        }

        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {

                long score = points[i][j];

                long max = Integer.MIN_VALUE;
                for (int k = 0; k < points[0].length; k++) {
                    max = Math.max(max, maxScore[i - 1][k] - Math.abs(k - j));
                }
                score += max;
                maxScore[i][j] = score;
            }
        }

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            max = Math.max(maxScore[points.length - 1][i], max);
        }
        return max;


    }
}
