package one;

public class ClimbingStairs {
    static int[] f;

    public static void main(String[] args) {

        int i = climbStairs(5);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        f = new int[n + 1];

        return recursive(n);
    }

    public static int recursive(int n) {

        if (n <= 2) {
            return n;
        }

        if (f[n] != 0) {
            return f[n];
        }

        int ways = recursive(n - 1) + recursive(n - 2);
        f[n] = ways;
        return ways;

    }


}
