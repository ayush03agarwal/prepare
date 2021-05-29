package one;

class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class MaxLeafSumBinaryTree {

    static Node root;
    static int max_so_far = Integer.MIN_VALUE;

    int maxPathSumUtil(Node node) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSumUtil(node.left);
        int right = maxPathSumUtil(node.right);
        int data = node.data;
        if (left > right) {
            max_so_far = left + data;
        } else {
            max_so_far = right + data;
        }
        return max_so_far;
    }

    //Driver program to test above functions
    public static void main(String args[]) {
        MaxLeafSumBinaryTree tree = new MaxLeafSumBinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSumUtil(root));
    }
}
