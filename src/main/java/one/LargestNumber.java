package one;

public class LargestNumber {


    private static String max;

    static void findMaximumNum(char[] chars, int k) {

        if (k == 0)
            return;

        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] < chars[j]) {
                    char ch = chars[i];
                    chars[i] = chars[j];
                    chars[j] = ch;

                    if (String.valueOf(chars).compareTo(max) > 0) {
                        max = String.valueOf(chars);
                    }
                    findMaximumNum(chars, k - 1);
                    char ch1 = chars[i];
                    chars[i] = chars[j];
                    chars[j] = ch1;
                }
            }
        }


    }


    public static void main(String[] args) {
        String str = "129814999";
        int k = 4;
        max = str;
        findMaximumNum(str.toCharArray(), k);
        System.out.print(max + "\n");
    }

}
