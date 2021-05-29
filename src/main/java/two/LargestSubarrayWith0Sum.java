package two;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWith0Sum {

    public static void main(String[] args) {
        int A[] = {-1, 1, -1, 1};
        System.out.println(maxLen(A, A.length));
    }

    static int maxLen(int arr[], int n) {

        Map<Integer, Integer> m = new HashMap<>();
        int s = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];

            if (s == 0) {
                max = i + 1;
            }

            if (m.get(s) != null) {
                int c = i - m.get(s);
                if (c > max) {
                    max = c;
                }
            } else {
                m.put(s, i);
            }
        }
        return max;
    }

}
