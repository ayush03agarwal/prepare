package one;

import java.util.*;

public class OrderOfCharacters {

    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> adj;
    static int maxLen = 0;
    static private int V;


    private static void printOrder(String[] words, int alpha) {
        V = alpha;
        adj = new ArrayList<>(alpha);
        visited = new boolean[V];
        for (int i = 0; i < alpha; ++i)
            adj.add(new ArrayList<>());

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    ArrayList<Integer> ch = adj.get(s1.charAt(j) - 'a');
                    ch.add(s1.charAt(j) - 'a');
                    ch.add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        topologicalSort();
    }


    static void topologicalSortImpl(int vertex) {
        ArrayList<Integer> integers = adj.get(vertex);
        for (int i : integers) {
            if (!visited[i]) {
                visited[i] = true;
                topologicalSortImpl(i);
                stack.push(i);
            }
        }
        if (!visited[vertex]) {
            visited[vertex] = true;
            stack.push(vertex);
        }
    }

    static void topologicalSort() {
        for (int i = 0; i < V; i++) {
            topologicalSortImpl(i);
        }
        while (!stack.isEmpty())
            System.out.println(Character.toChars(stack.pop() + 'a'));
    }

    public static void main(String[] args) {
        String[] words = {"caa", "aaa", "aab"};
        adj = new ArrayList<>();
        printOrder(words, 3);
    }
}
