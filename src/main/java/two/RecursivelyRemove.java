package two;

public class RecursivelyRemove {
    public static void main(String[] args) {

        String s = "acaaabbbacdddds";
        System.out.println(remove(s));
    }

    private static String remove(String s) {

        String f = "";
        boolean d = false;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                d = true;
            } else {
                c = s.charAt(i);
                if (!d) {
                    f += s.charAt(i - 1);
                }
                d = false;
            }
        }

        if (!d) {
            f += s.charAt(s.length() - 1);
        }

        return f;
    }


}
