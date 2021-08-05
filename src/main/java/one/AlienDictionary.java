package one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AlienDictionary {
    public static void main(String[] args) {

        String word[] = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(alienOrder(word));
    }


    public static String alienOrder(String[] words) {

        StringBuilder f = new StringBuilder();
        Map<Character, ArrayList<Character>> l = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int j = 0;
            while (j < s1.length() && j < s2.length() && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }
            if (j < s1.length() && j < s2.length()) {
                Character[] ch = new Character[2];
                ch[0] = s1.charAt(j);
                ch[1] = s2.charAt(j);
                ArrayList<Character> orDefault = l.getOrDefault(ch[0], new ArrayList<>());
                orDefault.add(ch[1]);
                l.put(ch[0], orDefault);
            }
        }


        Stack<Character> stack = new Stack<>();

        boolean[] visited = new boolean[26];
        for (Map.Entry<Character, ArrayList<Character>> e : l.entrySet()) {
            if (visited[e.getKey() - 'a']) {
                continue;
            }
            dfs(visited, l, e.getKey(), stack);
        }


        while (!stack.isEmpty()) {
            f.append(stack.pop());
        }
        return f.toString();
    }

    private static void dfs(boolean[] visited, Map<Character, ArrayList<Character>> l, Character key, Stack<Character> stack) {

        if (key == null) {
            return;
        }
        if (visited[key - 'a']) {
            return;
        }

        visited[key - 'a'] = true;

        ArrayList<Character> ch = l.get(key);
        if (ch != null) {
            for (Character c : ch) {
                dfs(visited, l, c, stack);
            }
        }
        stack.add(key);

    }
}
