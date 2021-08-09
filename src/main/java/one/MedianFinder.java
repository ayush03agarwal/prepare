package one;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {


    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        mf.addNum(4);
        mf.addNum(5);
        mf.addNum(6);
        System.out.println(mf.findMedian());
    }

    public void addNum(int num) {

        if (max.size() == min.size()) {
            if (max.isEmpty() && min.isEmpty()) {
                max.add(num);
            } else {
                if (num <= min.peek()) {
                    max.add(num);
                } else {
                    int minpop = min.poll();
                    max.add(minpop);
                    min.add(num);
                }
            }
        } else {
            if (num >= max.peek()) {
                min.add(num);
            } else {
                int maxpop = max.poll();
                max.add(num);
                min.add(maxpop);
            }

        }

    }

    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        } else {
            return (double) (max.peek() + min.peek()) / 2;
        }
    }
}
