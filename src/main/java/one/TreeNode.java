package one;

import lombok.Data;

@Data
public class TreeNode {

    // data members
    private int key;
    private int visited;
    private TreeNode left;
    private TreeNode right;


    // Constructor
    public TreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
        visited = 0;
    }

    // Methods to set left and right subtrees
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}
