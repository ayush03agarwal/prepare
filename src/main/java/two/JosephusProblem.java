package two;

import java.util.ArrayList;

public class JosephusProblem {
    public static void main(String[] args) {

        System.out.println(josephus(5, 3));
    }

    static int K = 0;

    public static int josephus(int n, int k) {
        ArrayList<Integer> a = new ArrayList();
        for (int i = 1; i <= n; i++) {
            a.add(i);
        }
        K = k;
        jose(n, k, 0, a);
        return a.get(0);
    }

    private static void jose(int n, int k, int pos, ArrayList<Integer> a) {
        if (a.size() == 1) {
            return;
        }

        if (k == 1) {
            a.remove(pos);
            k = K;
        }

        pos = (pos + 1) % a.size();
        jose(n, k - 1, pos, a);
    }


}
