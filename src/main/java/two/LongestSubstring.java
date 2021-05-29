package two;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        String sub = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                while (map.containsKey(c)) {
                    char c1 = sub.charAt(0);
                    sub = sub.substring(1);
                    map.remove(c1);
                }

            }
            sub += c;
            map.put(c, i);
            if (sub.length() > len) {
                len = sub.length();
            }
        }
        return len;
    }
}
