package two;

public class RearrangeArrayAlternately {

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6};
        rearrange(a, 6);
        System.out.println(a);
    }

    public static void rearrange(int arr[], int n) {
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = arr[j];

            arr[i] = b;
            arr[j] = a;

        }
    }
}
