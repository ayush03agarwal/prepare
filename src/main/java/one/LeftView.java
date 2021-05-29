package one;
/* Class containing left and right child of current
node and data value*/

/* Class to print the left view */
class LeftView {
    Node root;
    static int max_level = 0;

    void leftViewUtil(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level > max_level) {
            System.out.println(node.data);
            max_level = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);

    }

    void leftView() {
        leftViewUtil(root, 1);
    }

    /* testing for example nodes */
    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        LeftView tree = new LeftView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.leftView();
    }
}
