package two;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5};
        System.out.println(twoSum(nums, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int f = target - nums[i];
            if(map.containsKey(f)){
                return new int[]{map.get(f) , i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");

    }
}
