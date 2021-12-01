package one;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {


    public static void main(String[] args) {

        List<String> strings = letterCombinations("2");
        System.out.println(strings);

    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() > 0) {
            combo(digits, 0, list, "");
        }
        return list;
    }

    private static void combo(String digits, int index, List<String> list, String pre) {
        if (index >= digits.length()) {
            list.add(pre);
            return;
        }

        String chars = mapDigitToStr(digits.charAt(index) - '0');
        for (int i = 0; i < chars.length(); i++) {
            combo(digits, index + 1, list, pre + chars.charAt(i));
        }

    }


    private static String mapDigitToStr(int i) {

        switch (i) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return "";


    }


}
