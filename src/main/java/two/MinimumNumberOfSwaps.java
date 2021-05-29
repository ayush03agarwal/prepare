package two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumNumberOfSwaps {

    public static void main(String[] args) {

        int[] a = {101, 758, 315, 730, 472,
                619, 460, 479};
        int n = a.length;
        System.out.println(minSwaps(a, n));

    }

    static int minSwaps(int[] arr, int N) {
        int c = 0;

        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);
        Map<Integer, Integer> md = new HashMap<>();

        for (int i = 0; i < temp.length; i++) {
            md.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {

            if (arr[i] != temp[i]) {
                int v1 = arr[i];
                int v2 = temp[i];
                Integer i1 = md.get(arr[i]);
                Integer i2 = md.get(temp[i]);
                swap(arr, i1, i2);
                c++;

                md.put(v1, i2);
                md.put(v2, i1);


            }

        }

        return c;
    }


    private static void swap(int[] a, int i, int j) {
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }


}
