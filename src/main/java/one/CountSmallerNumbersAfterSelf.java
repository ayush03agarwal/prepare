package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
    public static void main(String[] args) {

        int[] i = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        System.out.println(countSmaller(i));
    }

    public static List<Integer> countSmaller(int[] nums) {

        List<Integer> s = new ArrayList<>();

        List<Integer> rev = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            s.add(nums[i]);
            Collections.sort(s);
            int index = s.indexOf(nums[i]);
            rev.add(index);

        }
        Collections.reverse(rev);
        return rev;
    }
}
