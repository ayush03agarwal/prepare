package two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        max_of_subarrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3, 3);
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {

        ArrayList<Integer> a = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }

        for (int i = 0; i < arr.length - k; i++) {

            a.add(q.peek());

            q.remove(arr[i]);

            q.add(arr[k + i]);


        }

        a.add(q.peek());
        return a;

    }
}
