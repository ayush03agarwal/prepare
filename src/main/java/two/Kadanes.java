package two;

public class Kadanes {

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{
                74, -72, 94, -53, -59, -3, -66, 36, -13, 22, 73, 15, -52, 75
        }));
    }

    static int maxSubarraySum(int arr[]) {
        int s = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (s < arr[i] && s < 0) {
                s = arr[i];
            } else {
                s += arr[i];
            }
            if (s > max) {
                max = s;
            } else if (s < 0) {
                s = arr[i];
            }
        }
        return max;
    }
}
