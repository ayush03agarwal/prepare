package two;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {

        int arr[] = {2, 1, 4, 3, 6, 5};
        System.out.println(Arrays.toString(kthLargest(4, arr, arr.length)));

    }


    static int[] kthLargest(int k, int[] arr, int n) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] f = new int[n];

        q.add(arr[0]);
        for (int i = 1; i < n; i++) {

            if (q.size() < k) {
                q.add(arr[i]);
            } else {
                if (arr[i] > q.peek()) {
                    q.poll();
                    q.add(arr[i]);
                }
            }


            if (q.size() >= k)
                f[i] = q.peek();
            else
                f[i] = -1;
        }
        return f;

    }

}
