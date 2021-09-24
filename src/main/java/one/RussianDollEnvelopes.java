package one;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public static void main(String[] args) {

        int envelopes[][] = {{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11},
                {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}};
        System.out.println(maxEnvelopes(envelopes));
    }


    public static int maxEnvelopes(int[][] envelopes) {


        if (envelopes.length < 2) {
            return envelopes.length;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int f[] = new int[envelopes.length];

        f[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && f[j] >= f[i]) {
                    f[i] = 1 + f[j];
                }
            }
        }


        int max = 0;
        for (int i : f) {
            max = Math.max(i, max);
        }
        return max;
    }


}
