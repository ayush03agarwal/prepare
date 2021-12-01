package one;

public class ZigZagConversion {
    public static void main(String[] args) {

        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {


        String[] arr = new String[numRows];


        int index = 0;
        boolean up = false;
        int pointer = 0;

        if (numRows == 1) {
            return s;
        }

        while (index < s.length()) {
            if (pointer == 0) {
                up = false;
            } else if (pointer == numRows - 1) {
                up = true;
            }

            arr[pointer] = (arr[pointer] == null ? "" : arr[pointer]) + s.charAt(index);
            if (!up) {
                pointer++;
            } else {
                pointer--;
            }
            index++;
        }

        StringBuilder f = new StringBuilder();
        for (String s1 : arr) {
            if (s1 != null)
                f.append(s1);
        }

        return f.toString();
    }
}
