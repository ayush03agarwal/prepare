package one;

import lombok.Data;

@Data
public class TreeNode {

    // data members
    public int val;
    public int visited;
    public TreeNode left;
    public TreeNode right;


    // Constructor
    public TreeNode(int val) {
        this.val = val;
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
