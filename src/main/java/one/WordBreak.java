package one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    static Map<String, Boolean> b = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {


        if (s.equals("") || wordDict.contains(s)) {
            return true;
        }

        if (b.get(s) != null) {
            return b.get(s);
        }

        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                String str = s.substring(i + 1);
                boolean t = wordBreak(str, wordDict);
                b.put(str, t);
                if (t) {
                    return true;
                }
            }
        }

        return false;

    }
}
