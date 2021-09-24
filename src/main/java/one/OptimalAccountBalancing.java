package one;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
    public static void main(String[] args) {
        int[][] t = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        System.out.println(minTransfers(t));
    }

    public static int minTransfers(int[][] transactions) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }
        System.out.println(map);


        int minTran = Integer.MAX_VALUE;

        int arr[] = new int[map.size()];
        int c = 0;
        for (int i : map.values()) {
            arr[c++] = i;
        }

        for (int i = 0; i < arr.length; i++) {
//            dfs(arr , i )
        }


        return 0;
    }
}
