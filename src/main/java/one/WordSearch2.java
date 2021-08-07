package one;

import java.util.List;

public class WordSearch2 {
    public static void main(String[] args) {

        char[][] b = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };


        String[] s = {"oath", "pea", "eat", "rain"};
        System.out.println(exist(b, s));
    }

    public static List<String> exist(char[][] board, String[] words) {

        return null;

    }
}

class Trie {
    char data;
    int count;
    Trie child[] = new Trie[26];
    boolean isWord;
    int wordEnd;
}