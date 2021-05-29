package one;

/* A Naive recursive implementation of LCS problem in java*/
public class LongestCommonSubsequence {

    static int[][] mat;

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        mat = new int[s2.length()][];
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs(X, Y, m, n));
    }

    private String lcs(char[] x, char[] y, int xLen, int yLen) {
        return null;
    }

}

// This Code is Contributed by Saket Kumar
