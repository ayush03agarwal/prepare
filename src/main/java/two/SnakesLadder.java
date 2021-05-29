package two;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesLadder {
    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));

    }

    private static String getMinDiceThrows(int[] moves, int n) {


        Queue<Store> q = new LinkedList<>();
        boolean arr[] = new boolean[n];
        arr[0] = true;
        q.add(new Store(0, 0));
        int f = -1;

        while (!q.isEmpty() && f == -1) {

            Store s = q.peek();
            q.remove();

            if (s.source == n - 1) {
                f = s.dist;
            }

            for (int i = s.source + 1; i <= (s.source + 6) && i < n; i++) {
                if (!arr[i]) {
                    Store s1 = new Store(i, s.dist + 1);

                    if (moves[i] != -1) {
                        s1.source = moves[i];
                    }

                    q.add(s1);
                    arr[s1.source] = true;

                }

            }

            System.out.println("hh");


        }

        return f + "";


    }


    @AllArgsConstructor
    static class Store {
        int source;
        //        int dest;
        int dist;
    }
}

