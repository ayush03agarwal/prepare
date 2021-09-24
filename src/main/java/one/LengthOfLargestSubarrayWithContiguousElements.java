package one;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLargestSubarrayWithContiguousElements {
    public static void main(String[] args) {

        int a[] = {10, 12, 12, 10, 10, 11, 10};
        System.out.println(findLength(a));
    }

    static int findLength(int arr[]) {

        Map<Integer, Integer> m = new HashMap<>();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int min = arr[i];
            m = new HashMap<>();
            for (int j = i; j < arr.length; j++) {

                if (m.get(arr[j]) == null) {
                    m.put(arr[j], j);
                } else {
                    break;
                }
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);
                if (max - min == j - i && len < j - i + 1) {
                    len = j - i + 1;
                }
            }
        }
        return len;
    }

}
