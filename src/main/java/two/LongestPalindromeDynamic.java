package two;

public class LongestPalindromeDynamic {
    public static void main(String[] args) {
        String s = "rfkqyuqfjkxy";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        boolean m[][] = new boolean[s.length()][s.length()];

        int max = 0;
        String f = "";
        for (int i = 0; i < s.length(); i++) {
            m[i][i] = true;
            max = 1;
            if (f.length() < s.substring(i, i + 1).length()) {
                f = s.substring(i, i + 1);
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                m[i][i + 1] = true;
                if (f.length() < s.substring(i, i + 1).length()) {
                    f = s.substring(i, i + 1);
                }
            } else {
                m[i][i + 1] = false;
            }
        }


        int c = 2;

        for (int j = c; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + c < s.length()) {
                    if ((s.charAt(i) == s.charAt(i + c))
                            && m[i + 1][i + c - 1]) {
                        m[i][i + c] = true;
                        max = c + 1;
                        if (f.length() < s.substring(i, i + c + 1).length()) {
                            f = s.substring(i, i + c + 1);
                        }
                    }
                }
            }
            c++;
        }
        return f;
    }


}
