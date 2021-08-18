package one;

import java.util.ArrayList;
import java.util.List;

public class PermutationNumber {

    public static void main(String[] args) {
        int n[] = {1, 2, 3};
        System.out.println(permute(n));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            result.add(l);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {

            swap(nums, 0, i);
            List<Integer> l = new ArrayList<>();

//            result

        }
        return null;

    }

    private static void swap(int num[], int i, int j) {
        int k = num[i];
        num[i] = num[j];
        num[j] = k;
    }


}
