package one;

import java.util.Arrays;

public class AnagramOfStringS1StringS2 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }


    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int ch[] = new int[26];
        int ch2[] = new int[26];
        int i = 0;
        while (i < s1.length()) {
            int index = s1.charAt(i) - 'a';
            ch[index] = ch[index] + 1;
            i++;
        }

        int l = 0;
        int r = 0;
        while (r < s2.length()) {
            if (Arrays.equals(ch2, ch)) {
                return true;
            }
            if (r - l < s1.length()) {
                int index = s2.charAt(r) - 'a';
                ch2[index] = ch2[index] + 1;
            } else {
                int f = s2.charAt(l) - 'a';
                ch2[f] = ch2[f] - 1;
                int index = s2.charAt(r) - 'a';
                ch2[index] = ch2[index] + 1;
                l++;
            }
            r++;
        }

        return Arrays.equals(ch2, ch);


    }

}
