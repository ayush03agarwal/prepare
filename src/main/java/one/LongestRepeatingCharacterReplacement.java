package one;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABACABBABABAAAA", 2));
    }

    public static int characterReplacement(String s, int k) {

        if (s.length() < 2) {
            return s.length();
        }
        int max = 0;
        int l = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
            int maxCh = Collections.max(m.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
            int windowSize = r - l + 1;
            int repReq = windowSize - maxCh;
            while (repReq > k) {
                m.put(s.charAt(l), m.get(s.charAt(l)) - 1);
                l++;
                maxCh = Collections.max(m.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
                windowSize = r - l + 1;
                repReq = windowSize - maxCh;
            }
            max = Math.max(windowSize, max);
        }
        return max;
    }
}
