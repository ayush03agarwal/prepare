package two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinations {
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        rec(candidates, target, 0, new ArrayList<>());
        return answer;
    }


    static void rec(int[] candidates, int target, int start, List<Integer> temp) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            rec(candidates, target - candidates[i], i, temp);
            temp.remove(temp.size() - 1);
        }


    }


}
