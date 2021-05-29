package two;

public class Equilibrium {

    public static void main(String[] args) {
        System.out.println(equilibriumPoint(new long[]{20, 17, 42, 25, 32, 32, 30, 32, 37, 9, 2, 33, 31, 17, 14, 40, 9, 12, 36, 21, 8, 33, 6, 6, 10, 37, 12, 26, 21, 3
        }, 5));
    }

    public static int equilibriumPoint(long arr[], int n) {
        long s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }

        if (arr.length == 1) {
            return 1;
        } else if (arr.length == 0 || arr.length == 2) {
            return -1;
        } else {
            long l = arr[0];
            for (int j = 1; j < arr.length; j++) {
                long r = s - l - arr[j];
                if (l == r) {
                    return j;
                }
                l += arr[j];
            }
            return -1;
        }
    }
}
