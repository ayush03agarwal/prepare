package one;

public class WordDictionary {


    Node root;

    public WordDictionary() {
        root = new Node();
        root.ch = '\0';
        root.children = new Node[26];

    }

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        boolean search = wordDictionary.search("b..");// return True

        System.out.println(search);
    }

    public void addWord(String word) {

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

    }

    public boolean search(String word) {

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node n = null;
            if (ch == '.') {
                for (int j = 0; j < curr.children.length; j++) {
                    n = curr.children[j];
                    if (n != null) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, n.ch);
                        boolean t = search(sb.toString());
                        if (t) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int index = word.charAt(i) - 'a';
                n = curr.children[index];
                if (n == null) {
                    return false;
                }
            }
            curr = n;
        }
        return curr.isWordEnd;
    }

    class Node {
        char ch;
        Node children[];
        boolean isWordEnd;
    }


}
