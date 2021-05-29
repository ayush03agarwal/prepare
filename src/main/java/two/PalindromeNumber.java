package two;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        return palindrome(String.valueOf(x));
    }

    private static boolean palindrome(String s) {
        int j = s.length() - 1;
        boolean b = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(j--)) {
                b = false;
            }
        }
        return b;
    }
}
