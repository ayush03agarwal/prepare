package one;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] a = {{2, 4}, {5, 7}, {8, 10}, {11, 13}};
        int[] b = {3, 6};
        int[][] insert = insert(a, b);
        System.out.println(Arrays.toString(insert));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        if (intervals.length == 0) {
            intervals = new int[1][];
            intervals[0] = newInterval;
            return intervals;
        }

        boolean processed = false;
        ArrayList<Integer> p;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                p = new ArrayList<>();
                p.add(newInterval[0]);
                p.add(newInterval[1]);
                result.add(p);
                for (int j = i; j < intervals.length; j++) {
                    p = new ArrayList<>();
                    p.add(intervals[j][0]);
                    p.add(intervals[j][1]);
                    result.add(p);
                }
                processed = true;
                break;
            } else if (newInterval[0] > intervals[i][1]) {
                p = new ArrayList<>();
                p.add(intervals[i][0]);
                p.add(intervals[i][1]);
                result.add(p);
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        if (!processed) {
            p = new ArrayList<>();
            p.add(newInterval[0]);
            p.add(newInterval[1]);
            result.add(p);
        }
        int[][] r = new int[result.size()][2];

        int c = 0;
        for (ArrayList<Integer> a : result) {
            int[] x = {a.get(0), a.get(1)};
            r[c++] = x;
        }
        return r;
    }
}
