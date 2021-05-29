package one;

public class SubstringSearch {

    /**
     * Slow method of pattern matching
     */
    public boolean hasSubstring(char[] text, char[] pattern) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                k = i;
                i++;
                j++;
            } else {
                j = 0;
                i = k + 1;
                k = i;
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeTemporaryArray(char pattern[]) {
        int[] lps = new int[pattern.length];
        int i = 0;
        int j = 1;
        lps[i] = 0;
        while (j < pattern.length) {
            if (pattern[i] == pattern[j]) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char[] text, char[] pattern) {

        int lps[] = computeTemporaryArray(pattern);
        int t = 0;
        int p = 0;
        while (t < text.length && p < pattern.length) {
            if (text[t] == pattern[p]) {
                p++;
                t++;
            } else {
                if (p == 0) {
                    p = 0;
                    t++;
                } else {
                    p = lps[p - 1];
                }
            }
        }
        return p == pattern.length;
    }

    public static void main(String args[]) {

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        SubstringSearch ss = new SubstringSearch();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);

    }
}
