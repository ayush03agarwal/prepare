package one;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    Node root;

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
        int a[] = {83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        System.out.println(c.countSmaller(a));
    }

    public Node insert(Node node, int value, int index, int[] res, int small) {
        if (node == null) {
            node = new Node();
            node.val = value;
            node.smallEle = 0;
            res[index] = small;
            return node;
        }
        if (node.val == value) {
            node.dup++;
            res[index] = node.smallEle + small;
        } else if (node.val > value) {
            node.smallEle++;
            node.left = insert(node.left, value, index, res, small);
        } else {
            node.right = insert(node.right, value, index, res, small + node.smallEle + node.dup);
        }
        return node;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] ans = new int[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            root = insert(root, n, i, ans, 0);
        }
        for (int an : ans) {
            result.add(an);
        }
        return result;
    }

    class Node {
        int val;
        int smallEle;
        int dup = 1;
        Node left;
        Node right;
    }

}
