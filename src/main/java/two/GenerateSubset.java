package two;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubset {


    public static void main(String[] args) {

        int a[] = {1, 2,3};
        System.out.println(subsets(a));

    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> f = new ArrayList<>();


        generate(nums, 0, new ArrayList<Integer>(), f);

        return f;
    }

    private static void generate(int[] nums, int pos, ArrayList<Integer> a, List<List<Integer>> f) {


        f.add(new ArrayList<>(a));


        for (int i = pos; i < nums.length; i++) {

            a.add(nums[i]);
            generate(nums, i + 1, a, f);
            a.remove(a.size() - 1);
        }


    }


}
