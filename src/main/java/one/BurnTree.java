package one;

import java.util.LinkedList;
import java.util.Queue;

public class BurnTree {

    private static Queue<TreeNode> q = new LinkedList<TreeNode>();
    static int target = 14;

    public static TreeNode getDummyTree() {
        TreeNode root = new TreeNode(12);
        root.setLeft(new TreeNode(13));
        root.setRight(new TreeNode(10));

        root.getRight().setLeft(new TreeNode(14));
        root.getRight().setRight(new TreeNode(15));

        root.getRight().getLeft().setLeft(new TreeNode(21));
        root.getRight().getLeft().setRight(new TreeNode(24));

        root.getRight().getRight().setLeft(new TreeNode(22));
        root.getRight().getRight().setRight(new TreeNode(23));

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = getDummyTree();
        findTarget(root, null);
        while (!q.isEmpty())
            burnTree(q);

    }

    private static void burnTree(Queue<TreeNode> q) {
        if (q.isEmpty()) {
            return;
        }
        while (q.peek() != null) {
            TreeNode peek = q.peek();
            if (peek.getVisited() == 0) {
                peek.setVisited(1);
                System.out.println(peek.getKey());
                if (peek.getLeft() != null)
                    q.add(peek.getLeft());
                if (peek.getRight() != null)
                    q.add(peek.getRight());
            }
        }
        q.remove();
    }

    private static void findTarget(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (node.getKey() == target) {
            System.out.println(node.getKey());
            if (node.getLeft() != null)
                q.add(node.getLeft());
            if (node.getRight() != null)
                q.add(node.getRight());
            if (parent != null)
                q.add(parent);
            q.add(null);
            return;
        }
        findTarget(node.getLeft(), node);
        findTarget(node.getRight(), node);
    }


}
