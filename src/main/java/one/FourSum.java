package one;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        if (nums.length < 4) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }

        }
        return new ArrayList<>(result);


    }


}
