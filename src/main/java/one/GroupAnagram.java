package one;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String s[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();

            Arrays.sort(c);
            String sorted = new String(c);
            List<String> l = map.getOrDefault(sorted, new ArrayList<>());
            l.add(s);
            map.put(sorted, l);
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}
