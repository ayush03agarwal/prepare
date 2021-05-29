package two;

import java.util.ArrayList;

public class StockBuyAndSell {
    public static void main(String[] args) {
        System.out.println(stockBuySell(new int[]{4, 2, 2, 2, 4}, 4));
    }

    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> f = new ArrayList<>();

        if (A.length < 2) {
            return f;
        }
        int d = 0;
        int l = A[0];
        int lI = 0;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(lI);
        for (int i = 1; i < A.length; i++) {
            if (A[i] - l > d) {
                d = A[i] - l;
            } else {
                a.add(i - 1);
                if (d != 0) {
                    f.add(a);
                }
                a = new ArrayList<>();
                l = A[i];
                lI = i;
                a.add(lI);
                d = 0;
            }
        }
        if (d > 0) {
            a.add(A.length - 1);
            f.add(a);
        }
        return f;
    }
}
