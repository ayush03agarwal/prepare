package one;

// Java program for implementation of Heap Sort
public class HeapSort {

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap


    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7, 1, 8, 9, 54, 23, 56, 34};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
    }

    private void sort(int[] arr) {
        int n = arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        System.out.println("Sorted : ");
        for (int i = n; i >= 0; i--) {
            System.out.println(arr[0]);
            int k = arr[i];
            arr[n] = arr[0];
            arr[0] = k;
            heapify(arr, 0, i);
        }
    }

    private void heapify(int[] arr, int index, int limit) {
        int x = 2 * index + 1;
        int y = 2 * index + 2;
        int k;
        if (x <= limit && y <= limit) {
            if (arr[index] < arr[x] || arr[index] < arr[y]) {
                int j = arr[index];
                if (arr[x] > arr[y]) {
                    k = x;
                    arr[index] = arr[x];
                    arr[x] = j;
                } else {
                    arr[index] = arr[y];
                    arr[y] = j;
                    k = y;
                }
                heapify(arr, k, limit);
            }
        }
    }
}
