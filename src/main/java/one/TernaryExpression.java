package one;

import java.util.Arrays;

// Class to convert a ternary expression to a Tree
class TernaryExpression {

    // Function to convert Ternary Expression to a Binary
    // Tree. It return the root of tree
    Node convertExpression(char[] expression, int i) {

        if (i >= expression.length) {
            return null;
        }

        char c = expression[i];
        Node node = new Node(c);
        i++;
        if (i < expression.length && expression[i] == '?') {
            node.left = convertExpression(expression, i + 1);
        } else if (i < expression.length) {
            node.right = convertExpression(expression, i + 1);
        }
        return node;
    }

    // function print tree
    public void printTree(Node root) {
        if (root == null)
            return;
        System.out.print(Arrays.toString(Character.toChars(root.data)) + " ");
        printTree(root.left);
        printTree(root.right);
    }

    // Driver program to test above function
    public static void main(String args[]) {
        String exp = "a?b?c:d:e";
        TernaryExpression tree = new TernaryExpression();
        char[] expression = exp.toCharArray();
        Node root = tree.convertExpression(expression, 0);
        tree.printTree(root);
    }
}

/* This code is contributed by Mr. Somesh Awasthi */
