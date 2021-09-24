package one;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {

        System.out.println(getMoneyAmount(10));
    }

    public static int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        Integer mem[][] = new Integer[n + 1][n + 1];
        return getAmt(1, n, mem);
    }


    private static int getAmt(int low, int high, Integer[][] mem) {

        if (low >= high) {
            return 0;
        }

        if (mem[low][high] != null) {
            return mem[low][high];
        }


        int cost = Integer.MAX_VALUE;

        for (int i = low; i <= high; i++) {
            cost = Math.min(cost, i + Math.max(getAmt(low, i - 1, mem), getAmt(i + 1, high, mem)));
        }

        mem[low][high] = cost;
        return cost;

    }

}
