package two;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.this.program.very.much"));

    }

    static String reverseWords(String S) {
        StringBuilder r = new StringBuilder();
        String[] split = S.split("\\.");
        String[] split2 = new String[split.length];
        int c = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            split2[i] = split[c++];
        }
        for (int i = 0; i < split.length; i++) {
            r.append(split2[i]).append(".");
        }
        return r.substring(0, r.length() - 1);
    }
}
