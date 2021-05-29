package two;

public class TrappingRainWater {
    public static void main(String[] args) {

        System.out.println(trappingWater(new int[]{8, 8, 2, 4, 5, 5, 1}, 4));
    }


    static int trappingWater(int arr[], int n) {
        if (arr.length < 3) {
            return 0;
        }
        int f = 0;
        for (int i = 1; i < arr.length; i++) {

            int l = -1;
            int r = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > l) {
                    l = arr[j];
                }
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > r) {
                    r = arr[j];
                }
            }

            if (l == -1 || r == -1 || arr[i] >= l || arr[i] >= r) {
                continue;
            }

            f += Math.abs(Math.min(l, r) - arr[i]);
        }

        return f;
    }
}
