package one;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int i[][] = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(i));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals.length;
        }

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 0;

        int l[] = intervals[0];
        for (int j = 1; j < intervals.length; j++) {
            int r[] = intervals[j];
            if (l[1] <= r[0]) {
                l = r;
            } else if (l[1] <= r[1]) {
                count++;
            } else if (l[1] > r[1]) {
                count++;
                l = r;
            }
        }
        return count;
    }
}
