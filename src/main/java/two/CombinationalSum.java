package two;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationalSum {
    public static void main(String[] args) {


        int arr[] = {9, 2, 7, 6, 1, 5};
        System.out.println(combinationSum(arr, arr.length, 8));
    }


    static ArrayList<ArrayList<Integer>> combinationSum(int A[], int N, int B) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> f = new ArrayList<>();

        Arrays.sort(A);

        sum(A, 0, B, f, a);

        return f;

    }

    private static void sum(int[] arr, int index, int sum, ArrayList<ArrayList<Integer>> f, ArrayList<Integer> a) {

        if (sum == 0) {
            f.add(new ArrayList<>(a));
            a = new ArrayList<>();
            return;
        }

        for (int i = index; i < arr.length; i++) {

            if (sum - arr[i] >= 0) {
                a.add(arr[i]);
                sum(arr, i + 1, sum - arr[i], f, a);
                a.remove(new Integer(arr[i]));
            }
        }


    }
}
