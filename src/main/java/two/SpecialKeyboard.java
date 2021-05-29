package two;

public class SpecialKeyboard {
    public static void main(String[] args) {

        System.out.println(optimalKeys(9));
    }

    static int max = 0;

    static int optimalKeys(int N) {
        if (N < 7) {
            return N;
        }

        for (int i = N - 3; i > 0; i--) {
            int c = (N - i - 1) * optimalKeys(i);
            if (c > max) {
                max = c;
            }
        }

        return max;

    }
}
