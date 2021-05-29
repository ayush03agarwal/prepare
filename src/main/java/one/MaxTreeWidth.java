package one;// Java program to calculate width of binary tree

/* A binary tree node has data, pointer to left child
and a pointer to right child */

import java.util.LinkedList;
import java.util.Queue;

class MaxTreeWidth {
    Node root;
    static int width = 0;
    static Queue<Node> queue = new LinkedList<>();


    /* Driver code */
    public static void main(String args[]) {
        MaxTreeWidth tree = new MaxTreeWidth();

		/*
		Constructed bunary tree is:
			1
			/ \
            2 3
            / \ \
            4 5	 8
				/ \
				6 7
		*/
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);


        System.out.println("Maximum width is "
                + tree.getMaxWidth(tree.root));
    }

    private int getMaxWidth(Node root) {
        // Function call
        queue.add(root);
        queue.add(null);
        int w = 0;
        while (!queue.isEmpty()) {

            if (width < w) {
                width = w;
            }
            Node remove = queue.remove();
            if (remove == null) {
                w = 0;
                queue.add(null);
            } else {
                w++;
                if (remove.left != null)
                    queue.add(remove.left);
                if (remove.right != null)
                    queue.add(remove.right);
            }
            if (queue.size() == 1 && queue.peek() == null) {
                queue.remove();
            }
        }
        return width;
    }
}

