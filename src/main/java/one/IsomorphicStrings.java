package one;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {

        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        Map<Character, Character> mapperS = new HashMap<>();
        Map<Character, Character> mapperT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            Character cM = mapperS.get(cS);
            if (cM == null) {
                if (mapperT.get(cT) != null) {
                    return false;
                }
                mapperS.put(cS, cT);
                mapperT.put(cT, cS);
            } else {
                if (cM != cT) {
                    return false;
                }
            }
        }
        return true;

    }
}
