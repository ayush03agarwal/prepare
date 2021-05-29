package two;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(9));
    }

    public static String intToRoman(int num) {
        String s = String.valueOf(num);
        StringBuilder f = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int c = Integer.parseInt(String.valueOf(s.charAt(i)));
            int m = s.length() - i;
            switch (m) {
                case 1:
                    if (c < 4) {
                        for (int j = 0; j < c; j++) {
                            f.append("I");
                        }
                    } else if (c == 4) {
                        f.append("IV");
                    } else if (c < 9) {
                        f.append("V");
                        int k = c % 5;
                        if (k > 0) {
                            for (int l = 0; l < k; l++) {
                                f.append("I");
                            }
                        }
                    } else {
                        f.append("IX");
                    }
                    break;
                case 2:
                    if (c < 4) {
                        for (int j = 0; j < c; j++) {
                            f.append("X");
                        }
                    } else if (c == 4) {
                        f.append("XL");
                    } else if (c < 9) {
                        f.append("L");
                        int k = c % 5;
                        if (k > 0) {
                            for (int l = 0; l < k; l++) {
                                f.append("X");
                            }
                        }
                    } else {
                        f.append("XC");
                    }
                    break;
                case 3:
                    if (c < 4) {
                        for (int j = 0; j < c; j++) {
                            f.append("C");
                        }
                    } else if (c == 4) {
                        f.append("CD");
                    } else if (c < 9) {
                        f.append("D");
                        int k = c % 5;
                        if (k > 0) {
                            for (int l = 0; l < k; l++) {
                                f.append("C");
                            }
                        }
                    } else {
                        f.append("CM");
                    }
                    break;
                case 4:
                    for (int j = 0; j < c; j++) {
                        f.append("M");
                    }
                    break;
            }
            i++;
        }
        return f.toString();
    }
}
