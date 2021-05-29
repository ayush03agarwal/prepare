package two;

import java.util.ArrayList;

public class SubarrayWithGivenSum {


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int s) {
        ArrayList<Integer> a = new ArrayList<>();
        int sum = 0;
        int f = 0;
        Integer start = 0;
        Integer end = null;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            f = s - sum;
            if (f < 0) {
                while (f < 0) {
                    sum -= arr[start++];
                    f = s - sum;
                }
                if (f == 0) {
                    end = i;
                    break;
                }
            } else if (f == 0) {
                end = i;
                break;
            }
        }
        if (end != null) {
            a.add(++start);
            a.add(++end);
        } else {
            a.add(-1);
        }
        return a;
    }
}
