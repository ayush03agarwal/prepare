package one;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aababbababab"));
    }

    public static String longestPalindrome(String s) {
        boolean m[][] = new boolean[s.length()][s.length()];
        int len = 0;
        String st = "";
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    m[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        m[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && m[i + 1][j - 1]) {
                        m[i][j] = true;
                    }
                }
                if (m[i][j]) {
                    st = s.substring(i, j + 1);
                    len = g + 1;
                }
            }
        }

        return st;
    }
}
