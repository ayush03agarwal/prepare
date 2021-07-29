package one;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int s[] = new int[]{-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4};
        List<List<Integer>> lists = threeSum(s);
        System.out.println(lists);
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // {-4,-3,-2,-1,-1,0,0,1,2,3,4}
        for (int i = 0; i < nums.length - 1; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (nums[l - 1] == nums[l] && l < r) {
                        l++;
                    }
                }
            }

        }
        return result;


    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, List<List<Integer>>> s = new HashMap<>();
        Set<List<Integer>> f = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                int sum = nums[i] + nums[j];
                List<List<Integer>> orDefault = s.getOrDefault(sum, new ArrayList<>());
                orDefault.add(l);
                s.put(sum, orDefault);
            }
        }

        for (Map.Entry<Integer, List<List<Integer>>> e : s.entrySet()) {
            Integer c = m.get(-1 * e.getKey());
            if (c != null) {

                for (List<Integer> x : e.getValue()) {
                    List<Integer> l = new ArrayList<>();
                    if (!x.contains(c)) {

                        for (int y : x) {
                            l.add(nums[y]);
                        }

                        l.add(-1 * e.getKey());
                        Collections.sort(l);
                        f.add(l);
                    }

                }

            }
        }

        return new ArrayList<>(f);


    }
}
