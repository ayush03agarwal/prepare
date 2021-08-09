package one;

public class Trie {

    Node root;

    public Trie() {
        root = new Node();
        root.ch = '\0';
        root.children = new Node[26];

    }

    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            Node n = curr.children[ch];
            if (n == null) {
                n = new Node();
                n.ch = word.charAt(i);
                curr.children[ch] = n;
            }
            curr = n;
        }
        curr.isWordEnd = true;

    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            Node n = curr.children[ch];
            if (n == null) {
                return false;
            }
            curr = n;
        }
        return curr.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            Node n = curr.children[ch];
            if (n == null) {
                return false;
            }
            curr = n;
        }
        return true;
    }

    class Node {
        char ch;
        Node children[];
        boolean isWordEnd;
    }


}
