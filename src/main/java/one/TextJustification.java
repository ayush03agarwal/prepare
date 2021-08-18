package one;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String w[] = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(w, 16));

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0;

        int n = words.length;

        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();

            while (j < n && (lineLength + words[j].length() + (j - i - 1)) < maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int diff = maxWidth - lineLength;
            int numOfWords = j - i;
            if (numOfWords == 1 || j >= n) {
                result.add(leftJustify(words, diff, i, j));
            } else {
                result.add(middleJustify(words, diff, i, j));
            }

            i = j;


        }

        return result;


    }

    private static String middleJustify(String[] words, int diff, int i, int j) {

        int spaceNeeded = j - i - 1;
        int spaces = diff / spaceNeeded;
        int extra = diff % spaceNeeded;

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            int spacesToApply = spaces + (extra-- > 0 ? 1 : 0);
            for (int x = 0; x < spacesToApply; x++) {
                sb.append(" ");
            }
            sb.append(words[k]);
        }
        return sb.toString();
    }

    private static String leftJustify(String[] words, int diff, int i, int j) {

        int spaceOnRight = diff - (j - i - 1);
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append(" ");
            sb.append(words[k]);
        }

        for (int k = 0; k < spaceOnRight; k++) {
            sb.append(" ");
        }

        return sb.toString();

    }
}
