package one;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {

        if (s.length() == 1) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);

            if (!Character.isLetterOrDigit(ch1)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(ch2)) {
                r--;
                continue;
            }

            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
