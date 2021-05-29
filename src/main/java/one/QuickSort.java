package one;

// Java program for implementation of one.QuickSort
class QuickSort {

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 2, -3, 3, 4, 5, 6, 7, 2, 4, 9, 111};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.print("sorted array : ");
        printArray(arr);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(arr, low, high);
        sort(arr, low, pivotIndex - 1);
        sort(arr, pivotIndex + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int index = high;
        int k = -1;
        for (int i = low; i < high; i++) {
            if (arr[index] < arr[i] && k == -1) {
                k = i;
            }
            if (arr[index] > arr[i] && k != -1) {
                int j = arr[k];
                arr[k] = arr[i];
                arr[i] = j;
                k++;
            }
        }
        if (k != -1) {
            int j = arr[k];
            arr[k] = arr[index];
            arr[index] = j;
            return k;
        }
        return high;
    }
}
/*This code is contributed by Rajat Mishra */
