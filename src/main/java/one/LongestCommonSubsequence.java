package one;

/* A Naive recursive implementation of LCS problem in java*/
public class LongestCommonSubsequence {


    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abcde", "abcde"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals("") || text2.equals("")) {
            return 0;
        }

        int[][] mat = new int[text1.length() + 1][text2.length() + 1];


        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                    continue;
                }
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        return mat[text1.length()][text2.length()];

    }

}

// This Code is Contributed by Saket Kumar
