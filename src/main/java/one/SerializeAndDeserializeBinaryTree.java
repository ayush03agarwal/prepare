package one;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    static List<String> listSer = new ArrayList<>();
    static int index = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));

        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(5));

        String s = serialize(root);
        System.out.println(s);

        TreeNode node = deserialize(s);
        System.out.println(node);

    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return String.join(",", listSer);
    }

    private static void dfs(TreeNode node) {

        if (node == null) {
            listSer.add("N");
            return;
        }

        listSer.add(String.valueOf(node.val));
        dfs(node.left);
        dfs(node.right);

    }

    public static TreeNode deserialize(String dataStr) {

        if (dataStr == null) {
            return null;
        }

        String data[] = dataStr.split(",");

        TreeNode root = parse(data);

        return root;
    }


    private static TreeNode parse(String[] data) {

        if (data[index].equals("N")) {
            index++;
            return null;
        }

        int val = Integer.parseInt(data[index++]);
        TreeNode node = new TreeNode();
        node.val = val;
        TreeNode left = parse(data);
        TreeNode right = parse(data);

        node.left = left;
        node.right = right;

        return node;
    }


}
