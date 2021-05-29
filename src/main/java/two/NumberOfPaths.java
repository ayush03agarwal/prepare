package two;

public class NumberOfPaths {

    public static void main(String[] args) {

        System.out.println(numberOfPaths(3, 3));

    }

    static long numberOfPaths(int m, int n) {

        System.out.println(m + " " + n);

        if (m == 1 || n == 1) {
            return 1;
        }

        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);

    }
}
