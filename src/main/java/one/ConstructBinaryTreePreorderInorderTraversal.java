package one;

import java.util.HashMap;

public class ConstructBinaryTreePreorderInorderTraversal {
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static int preIndex = 0;

    public static void main(String[] args) {

        int[] p = {3, 9, 20, 15, 7};
        int[] i = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(p, i);
        System.out.println(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }


        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = preorder[preIndex++];

        if (start == end) {
            return root;
        }

        int index = hm.get(root.val);

        root.left = build(preorder, inorder, start, index - 1);
        root.right = build(preorder, inorder, index + 1, end);


        return root;
    }


}
