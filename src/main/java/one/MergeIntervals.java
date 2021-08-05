package one;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {

        int[][] i = {{4, 18}, {1, 3}, {2, 4}};
        int[][] merge = merge(i);
        System.out.println(merge);
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));


        ArrayList<int[]> result = new ArrayList<>();
        int[] p;

        int prev[] = {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prev[1]) {
                p = new int[2];
                p[0] = prev[0];
                p[1] = prev[1];
                result.add(p);
                prev = new int[]{intervals[i][0], intervals[i][1]};
            } else {
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }

        p = new int[2];
        p[0] = prev[0];
        p[1] = prev[1];
        result.add(p);

        return result.toArray(new int[result.size()][]);
    }
}
