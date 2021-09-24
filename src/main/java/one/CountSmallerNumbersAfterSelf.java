package one;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
    Node root;
    int[] result;

    public static void main(String[] args) {

        int[] i = {5, 2, 6, 1};

        CountSmallerNumbersAfterSelf s = new CountSmallerNumbersAfterSelf();
        System.out.println(s.countSmaller(i));
    }

    private Node insert(Node n, int num, int index, int small) {
        if (n == null) {
            n = new Node();
            n.val = num;
            result[index] = small;
        } else if (num < n.val) {
            n.smallCount++;
            n.left = insert(n.left, num, index, small);
        } else if (num == n.val) {
            n.dup++;
            result[index] = small + n.smallCount;
        } else {
            n.right = insert(n.right, num, index, small + n.smallCount + n.dup);
        }
        return n;
    }

    public List<Integer> countSmaller(int[] nums) {
        result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], i, 0);
        }

        List<Integer> r = new ArrayList<>();
        for (int n : result) {
            r.add(n);
        }

        return r;

    }

    class Node {

        int val;
        int smallCount;
        int dup = 1;

        Node left;
        Node right;
    }
}
