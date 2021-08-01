package one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> m = new HashMap<>();
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (m.get(ch) == null) {
                m.put(ch, i);
                sb.append(ch);
            } else {
                while (sb.charAt(0) != ch) {
                    char removeCh = sb.charAt(0);
                    m.remove(removeCh);
                    sb.deleteCharAt(0);
                }
                sb.deleteCharAt(0);
                m.put(ch, i);
                sb.append(ch);
            }
            max = Math.max(max, sb.length());
        }


        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, set.size());
        }
        return max;
    }


}
