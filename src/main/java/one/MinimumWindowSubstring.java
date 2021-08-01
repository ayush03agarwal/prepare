package one;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> orgMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            orgMap.put(t.charAt(i), orgMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int reqCount = t.length();

        Map<Character, Integer> countMap = new HashMap<>();


        int l = 0;
        int result = Integer.MAX_VALUE;
        int matchCount = 0;
        int ll = -1;
        int rr = -1;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (orgMap.get(ch) != null) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
                if (countMap.get(ch) <= orgMap.get(ch)) {
                    matchCount++;
                }
                while (reqCount == matchCount && l <= r) {
                    int window = r - l + 1;
                    if (result > window) {
                        result = window;
                        ll = l;
                        rr = r;
                    }
                    l++;
                    char chL = s.charAt(l - 1);
                    if (orgMap.get(chL) != null) {
                        countMap.put(chL, countMap.get(chL) - 1);
                        if (countMap.get(chL) < orgMap.get(chL)) {
                            matchCount--;
                        }
                    }
                }


            }
        }

        return ll == -1 ? "" : s.substring(ll, rr + 1);

    }
}
