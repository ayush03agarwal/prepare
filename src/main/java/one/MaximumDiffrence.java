package one;

class MaximumDiffrence {
    int maxDiff(int arr[], int arr_size) {

        int max_diff = 0;
        int min_ele = arr[0];
        for (int i = 0; i < arr_size; i++) {

            if (arr[i] < min_ele) {
                min_ele = arr[i];
            }

            if (arr[i] - min_ele > max_diff) {
                max_diff = arr[i] - min_ele;
            }

        }

        return max_diff;
    }

    public static void main(String[] args) {
        MaximumDiffrence maxdif = new MaximumDiffrence();
        int arr[] = {91, 92, 90, 110, 10, 11, 12};
        int size = arr.length;
        System.out.println("MaximumDifference is " +
                maxdif.maxDiff(arr, size));
    }
}

