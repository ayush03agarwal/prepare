package one;

import java.util.HashMap;
import java.util.Map;

public class ValidSquare {
    public static void main(String[] args) {
        int p1[] = {0, 0};
        int p2[] = {1, 1};
        int p3[] = {1, 1};
        int p4[] = {0, 0};
        System.out.println(validSquare(p1, p2, p3, p4));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {


        Map<Integer, Integer> map = new HashMap<>();
        int arr[] = new int[6];
        arr[0] = getLen(p1, p2);
        arr[1] = getLen(p1, p3);
        arr[2] = getLen(p1, p4);
        arr[3] = getLen(p2, p3);
        arr[4] = getLen(p2, p4);
        arr[5] = getLen(p3, p4);

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if (map.size() == 2) {

            if (map.containsKey(0)) return false;

            int o = (int) map.values().toArray()[0];

            if (o == 2 || o == 4) {
                return true;
            }

        }

        return false;

    }

    private static int getLen(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
