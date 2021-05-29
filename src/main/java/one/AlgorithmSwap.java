package one;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class AlgorithmSwap {
    public static void main(String[] args) {
//int[] arr = new int[] {5,1,4,2,10,3,6,7,9,8,11};
        int[] arr = new int[]{5,1,4,2};

        TreeMap<Integer, Integer> tm = new TreeMap<>(); //elementValue -> count of elements greater than it and coming before it
        tm.put(arr[0], 0);
        int size = arr.length;
        int totCnt = 0;


        for (int i = 1; i < size; i++) {
            int cnt = 0;
            if (tm.higherKey(arr[i]) != null) {
                int num = tm.get(tm.higherKey(arr[i]));
                cnt = num + 1;
            } else {
                cnt = 0;
            }
            tm.put(arr[i], cnt);
//System.out.println(cnt);
            totCnt += cnt;
        }
        System.out.println(totCnt);
    }


}
