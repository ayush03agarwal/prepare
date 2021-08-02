package one;

public class CoinChange {


    public static void main(String[] args) {
        int i[] = new int[]{2};
        int k = coinChange(i, 3);
        System.out.println(k);
    }


    public static int coinChange(int[] coins, int amount) {

        int f[] = new int[amount + 1];
        f[0] = 0;

        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                int r = i - c;
                if (r >= 0 && f[r] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], 1 + f[r]);
                }
            }
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

}
