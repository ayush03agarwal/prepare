package one;

import java.util.ArrayList;

public class PrintPath {


    static ArrayList<Node> list = new ArrayList<>();
    static boolean found = false;

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(11);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.left.right = new Node(9);
        root.right.left = new Node(6);
        root.right.left.right = new Node(10);
        root.right.right = new Node(7);
        int x = 1;
        printPath(root, x);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).data);
        }
    }

    private static void printPath(Node root, int x) {
        if (root == null || found) {
            return;
        }
        list.add(root);
        printPath(root.left, x);
        printPath(root.right, x);
        if (!hasNode(root, x) && !found) {
            list.remove(root);
        }
    }

    private static boolean hasNode(Node node, int x) {
        if (node == null) {
            return false;
        }
        hasNode(node.left, x);
        hasNode(node.right, x);
        if (node.data == x) {
            found = true;
            return true;
        }
        return false;
    }
}
