package one;

import java.util.*;

class TopViewBinaryTree {
    Node root;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public TopViewBinaryTree() {
        root = null;
    }

    private void topView(Node root, int width) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> integers = map.get(width);
        if (integers == null) {
            ArrayList<Integer> aa = new ArrayList<>();
            aa.add(root.data);
            map.put(width, aa);
        } else {
            integers.add(root.data);
            map.put(width, integers);
        }
        topView(root.left, width - 1);
        topView(root.right, width + 1);
    }

    public static void main(String[] args) {
		/* Create following Binary Tree
			   1
	    	/    \
	    	2     3
		    \
			  4
		        \
		       	 5
			      \
				   6
         */
        TopViewBinaryTree tree = new TopViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topView(tree.root, 0);

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().get(0));
        }
    }

}
