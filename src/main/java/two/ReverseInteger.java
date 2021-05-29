package two;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int a) {
        int y = 0;
        int z = 10;
        int x = Math.abs(a);
        while (x > 0) {
            int i = x % 10;
            if (Integer.MAX_VALUE / 10 < y) {
                return 0;
            }
            int j = z * y;
            if (Integer.MAX_VALUE - j < i) {
                return 0;
            }
            y = i + j;

            x = x / 10;
        }
        if (a < 0) {
            return -1 * y;
        } else {
            return y;
        }
    }
}
