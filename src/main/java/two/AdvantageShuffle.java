package two;

public class AdvantageShuffle {
    public static void main(String[] args) {

        int[] A = new int[]{15448, 14234, 13574, 19893, 6475};
        int[] B = new int[]{14234, 6475, 19893, 15448, 13574};
        System.out.println(advantageCount(A, B));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        int[] C = new int[A.length];
        for (int i = 0; i < A.length; i++) {


            boolean g = false;
            Integer k = null;
            Integer x = null;
            Integer l = null;

            for (int j = i; j < A.length; j++) {
                if (A[j] > B[i]) {
                    if (k == null
                            || A[j] < k) {
                        k = A[j];
                        l = j;
                    }
                    g = true;
                } else {
                    if (!g) {
                        if (x == null
                                || A[j] < x) {
                            x = A[j];
                            l = j;
                        }
                    }
                }
            }

            if (l != null) {
                swap(A, i, l);
            }
            C[i] = A[i];
        }
        return C;
    }

    private static void swap(int[] a, int i, int j) {
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }
}
