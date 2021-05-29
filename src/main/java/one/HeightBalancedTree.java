package one;/* Java program to determine if binary tree is
height balanced or not */

/* A binary tree node has data, pointer to left child,
and a pointer to right child */

class HeightBalancedTree {
    Node root;

    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int hL = heightTree(node.left);
        int hR = heightTree(node.right);

        return Math.abs(hL - hR) <= 1
                && isBalanced(node.left)
                &&
                isBalanced(node.right);
    }

    int heightTree(Node node) {
        if (node == null) {
            return 0;
        }

        int hL = heightTree(node.left);
        int hR = heightTree(node.right);

        return 1 + (hL > hR ? hL : hR);

    }

    public static void main(String args[]) {
        HeightBalancedTree tree = new HeightBalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

