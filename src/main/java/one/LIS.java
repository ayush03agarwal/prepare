package one;

class LIS {

    static void print(int lis[] , int arr[]) {
        int max = lis[0];
        for (int i = 1; i < lis.length; i++)
            if (lis[i] > max)
                max = lis[i];

        for (int i = lis.length - 1; i >= 0; i--) {
            if (lis[i] == max) {
                System.out.println(arr[i]);
                max--;
            }

        }
    }

    static int[] lis(int arr[], int n) {
        int[] lis = new int[arr.length];
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] &&
                        lis[i] <= lis[j]) {
                    lis[i] = 1 + lis[i];
                }
            }
        }
        return lis;
    }

    // driver program to test above functions
    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;
        int[] lis = lis(arr, n);
        int max = lis[0];
        for (int i = 1; i < arr.length; i++)
            if (lis[i] > max)
                max = lis[i];

        System.out.println("Max : " + max);
        print(lis , arr);
    }
}
