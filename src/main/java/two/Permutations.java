package two;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<String> abc = find_permutation("ABC");
        System.out.println(abc);
    }

    public static List<String> find_permutation(String S) {
        List<String> f = new ArrayList<>();
        for (int i = 0; i < S.length() - 1; i++) {

            find_permutation(S , f);
        }
        return f;
    }

    private static void find_permutation(String s, List<String> f) {

    }


}
