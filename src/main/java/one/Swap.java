package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap {


    static class Point implements Comparable<Point> {

        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point other) {
            return this.x - other.x;
        }
    }

    // Function to find minimum swaps to
// sort an array
    static int findMinSwap(int[] arr, int n) {

        // Declare a vector of pair
        List<Point> vec = new ArrayList<Point>();

        for (int i = 0; i < n; i++) {
            vec.add(new Point(arr[i], i));
        }

        // Sort the vector w.r.t the first
        // element of pair
        Collections.sort(vec);
        int ans = 0;
        for (int i = 0; i < n; i++) {

            // If the element is already placed
            // correct, then continue
            if (vec.get(i).y == i)
                continue;
            else {

                // Swap with its respective index
                Point temp = vec.get(vec.get(i).y);
                vec.set(vec.get(i).y, vec.get(i));
                vec.set(i, temp);
            }

            // Swap until the correct
            // index matches
            if (i != vec.get(i).y)
                --i;

            // Each swap makes one element
            // move to its correct index,
            // so increment answer
            ans++;
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2};
        int n = arr.length;
        System.out.println(findMinSwap(arr, n));
    }


}
