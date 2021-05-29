package one;

public class Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);
    }

    private static void permute(String str, int initial, int end) {
        if (initial == end) {
            System.out.println(str);
        } else {
            for (int i = initial; i <= end; i++) {
                str = swap(str, initial, i);
                permute(str, initial + 1, end);
                str = swap(str, initial, i);
            }
        }

    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}