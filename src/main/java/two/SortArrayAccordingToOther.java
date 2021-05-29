package two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortArrayAccordingToOther {

    public static void main(String[] args) {

        int A1[] = {45, 15, 23, 8, 5, 12, 26, 444, 888, 151, 12, 23, 45, 15, 56};
        int A2[] = {15, 888, 444, 5, 8, 12, 23};

        System.out.println(Arrays.toString(sortA1ByA2(A1, A1.length, A2, A2.length)));
    }

    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {

        LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
        Arrays.sort(A1);

        for (int i = 0; i < A1.length; i++) {
            if (m.get(A1[i]) == null) {
                m.put(A1[i], 1);
            } else {
                m.put(A1[i], m.get(A1[i]) + 1);
            }
        }

        int A3[] = new int[A1.length];
        int k = 0;
        for (int i = 0; i < A2.length; i++) {
            Integer c = m.get(A2[i]);
            if (c != null) {
                for (int j = 0; j < c; j++) {
                    A3[k++] = A2[i];
                }
                m.remove(A2[i]);
            }
        }

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            for (int j = 0; j < e.getValue(); j++) {
                A3[k++] = e.getKey();
            }
        }


        return A3;

    }
}
