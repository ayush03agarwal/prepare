package two;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();
        if (strs.length > 0) {
            String s1 = strs[0];
            for (int j = 0; j < s1.length(); j++) {
                boolean f = true;
                char c1 = s1.charAt(j);
                for (int i = 0; i < strs.length; i++) {
                    String str = strs[i];
                    if (str.length() <= j) {
                        f = false;
                        break;
                    }
                    char c = str.charAt(j);
                    if (c1 != c) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    s.append(c1);
                } else {
                    break;
                }
            }
        }
        return s.toString();
    }
}
