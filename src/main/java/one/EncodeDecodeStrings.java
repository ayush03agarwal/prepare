package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        String r = encode(Arrays.asList("lint", "code", "love", "you"));
        List<String> s = decode(r);
        System.out.println(s);
    }

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {

        String result = "";
        for (String i : strs) {
            result += i.length() + "#" + i;
        }
        return result;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < str.length()) {

            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int l = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + l));
            i = j + l + 1;
        }
        return result;
    }
}
