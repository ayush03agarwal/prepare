package two;

import java.util.Arrays;

public class ZigZag {
    public static void main(String[] args) {

        zigZag(new int[]{1567,1655,1843,9847,9534,9644,1400,8082,3505,573,84,6126,4262,961,6211,8081,3309,5150,3500,8769,4516,5196,8940,7407,6268
        }, 3);
    }

    static void zigZag(int arr[], int n) {

        if (arr.length == 1) {
            System.out.println(arr[0]);
        }

        int t1 = -1;
        for (int i = 1; i < arr.length; i++) {
            int c = 0;
            if (t1 == -1) {
                if ((arr[i - 1] > arr[i])) {
                    c = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = c;
                }
                t1 = 1;
            } else {
                if (arr[i - 1] < arr[i]) {
                    c = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = c;
                }
                t1 = -1;
            }

        }
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }

    }
}
