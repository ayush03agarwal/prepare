package two;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 10, 3, 5, 1};
        heapSort(arr, arr.length);
        System.out.println(arr);
    }


    //Heapify function to maintain heap property.
    static void heapify(int arr[], int n, int i) {

        int l = 2 * i + 1;
        int r = 2 * i + 2;

        int m = i;
        if (l < n && arr[l] > arr[m]) {
            m = l;
        }

        if (r < n && arr[r] > arr[m]) {
            m = r;
        }

        if (m != i) {
            swap(arr, i, m);
            heapify(arr, n, m);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
    }


    //Function to sort an array using Heap Sort.
    static public void heapSort(int arr[], int n) {

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

    }


}
