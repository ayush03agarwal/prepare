package one;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("2100"));
    }

    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int count1 = 1;
        int count2 = 1;

        for (int i = 1; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            int dd = (s.charAt(i - 1) - '0') * 10 + d;
            int count = 0;
            if (d > 0) {
                count += count1;
            }
            if (dd >= 10 && d <= 26) {
                count += count2;
            }
            count2 = count1;
            count1 = count;
        }


        return count1;
    }
}
