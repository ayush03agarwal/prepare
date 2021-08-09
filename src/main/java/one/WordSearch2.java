package one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

    Node root;
    Set<String> result = new HashSet<>();
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    WordSearch2() {
        root = new Node();
        root.ch = '\0';
        root.children = new Node[26];
    }

    public static void main(String[] args) {

        char[][] b = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };


        String[] s = {"oath", "pea", "eat", "rain"};

        WordSearch2 ws = new WordSearch2();
        List<String> exist = ws.exist(b, s);

        System.out.println(exist);
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            Node n = curr.children[ch];
            if (n == null) {
                n = new Node();
                n.children = new Node[26];
                n.ch = word.charAt(i);
                curr.children[ch] = n;
            }
            curr = n;
        }
        curr.isWordEnd = true;
        curr.word = word;
    }

    public List<String> exist(char[][] board, String[] words) {
        for (String s : words) {
            insert(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return new ArrayList<>(result);

    }

    private void dfs(char[][] board, int i, int j, Node root) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$' || root == null) {
            return;
        }
        char ch = board[i][j];
        board[i][j] = '$';
        Node check = root.children[ch - 'a'];
        if (check != null) {
            if (check.isWordEnd) {
                result.add(check.word);
            }
            for (int a = 0; a < dir.length; a++) {
                dfs(board, i + dir[a][0], j + dir[a][1], check);
            }
        }
        board[i][j] = ch;

    }

    class Node {
        char ch;
        Node children[];
        boolean isWordEnd;
        String word;
    }


}

