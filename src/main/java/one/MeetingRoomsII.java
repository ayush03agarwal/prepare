package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomsII {
    public static void main(String[] args) {

        List<Interval1> intervals = new ArrayList<>();
        intervals.add(new Interval1(0, 30));
        intervals.add(new Interval1(5, 10));
        intervals.add(new Interval1(15, 20));


        System.out.println(minMeetingRooms(intervals));

    }

    public static int minMeetingRooms(List<Interval1> intervals) {

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int c = 0;
        for (Interval1 i : intervals) {
            start[c] = i.start;
            end[c] = i.end;
            c++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int max = 0;
        int l = 0;
        int r = 0;
        int count = 0;
        while (l < intervals.size()) {
            if (end[r] > start[l]) {
                count++;
                l++;
            } else {
                r++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;


    }
}

class Interval1 {
    int start, end;

    Interval1(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

