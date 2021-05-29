package two;

public class FormPalindrome {

    public static void main(String[] args) {
        String s = "aa";

        System.out.println(countMin(s));
    }


    static int countMin(String str) {
        return countMin(str, 0, str.length() - 1);
    }

    static int countMin(String str, int l, int h) {
        if (l == h
                || l >= str.length()
                || h <= 0
        ) {
            return 0;
        }
        if (str.charAt(l) == str.charAt(h)) {
            return countMin(str, l + 1, h - 1);
        } else {
            return 1 + Math.min(
                    countMin(str, l, h - 1),
                    countMin(str, l + 1, h)
            );
        }

    }
}
