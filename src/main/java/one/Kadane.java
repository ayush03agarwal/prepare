package one;

class Kadane {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[]) {
        int max_so_far = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (max_so_far < sum) {
                if (sum > a[i])
                    max_so_far = sum;
                else {
                    max_so_far = a[i];
                    sum = a[i];
                }
            }
        }
        return max_so_far;
    }
} 
