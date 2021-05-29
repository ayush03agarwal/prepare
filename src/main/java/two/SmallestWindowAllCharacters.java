package two;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowAllCharacters {

    public static void main(String[] args) {

        String S = "this is a test string";
        String P = "tist";

        System.out.println(smallestWindow(S, P));

    }

    public static String smallestWindow(String s, String p) {
        String f = s;
        if (s.length() < p.length()) {
            return "-1";
        }

        Map<Character, Integer> ms = new HashMap<>();
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            if (mp.get(p.charAt(i)) != null) {
                mp.put(p.charAt(i), mp.get(p.charAt(i)) + 1);
            } else {
                mp.put(p.charAt(i), 1);
            }
        }
        int c = 0;
        int st = 0;
        int en = -1;

        for (int i = 0; i < s.length(); i++) {

            if (p.indexOf(s.charAt(i)) != -1) {

                if (ms.get(s.charAt(i)) != null) {
                    ms.put(s.charAt(i), ms.get(s.charAt(i)) + 1);
                } else {
                    ms.put(s.charAt(i), 1);
                }
                char ch = s.charAt(i);
                int pc = mp.get(ch);
                if (pc >= ms.get(ch)) {
                    c++;
                }

                int cc = mp.values().stream().reduce(0, Integer::sum);
                if (c == cc) {
                    en = i;
                    String ns = s.substring(st, en + 1);
                    if (f.length() > ns.length()) {
                        f = ns;
                    }
                }


                if (en != -1) {
                    st = st + 1;
                    while (en < s.length() && en > st) {
                        char stch = s.charAt(st);
                        if (ms.get(stch) != null) {
                            ms.put(stch, ms.get(stch) - 1);

                            int msc = ms.get(stch);
                            int mpc = mp.get(stch);

                            if (msc < mpc) {
                                c--;
                            } else {
                                String ns = s.substring(st, en + 1);
                                if (f.length() > ns.length()) {
                                    f = ns;
                                }
                            }

                        }
                        i++;

                    }


                }


            }
        }


        return null;
    }
}
