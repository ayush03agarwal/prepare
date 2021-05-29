package two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistanceToCharacter {

    public static void main(String[] args) {
        int[] ints = shortestToChar("loveleetcode", 'e');
        System.out.println(ints);
    }

    public static int[] shortestToChar(String s, char c) {
        int[] f = new int[s.length()];
        Map<Character, List<Integer>> m = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> l;
            char c1 = s.charAt(i);
            if (m.get(c1) == null) {
                l = new ArrayList();
                l.add(i);
            } else {
                l = m.get(c1);
                l.add(i);
            }
            m.put(c1, l);
        }
        for (int i = 0; i < s.length(); i++) {
            List<Integer> l = m.get(c);
            if (s.charAt(i) == c) {
                f[i] = 0;
            } else {
                int k = s.length() + 1;
                for (int j : l) {
                    int a = Math.abs(i - j);
                    if (k > a) {
                        k = a;
                    }
                    f[i] = k;
                }
            }
        }
        return f;
    }
}
