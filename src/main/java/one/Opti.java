package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opti {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(2);
        System.out.println(minimalHeaviestSetA(arr));
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {

        List<Integer> resultList = new ArrayList<>();
        int sumA = 0;
        int arrayLen = arr.size();
        arr.sort(Collections.reverseOrder());
        for (int i = 0; i < arrayLen; i++) {
            int pointer = i + 1;
            sumA += arr.get(i);
            resultList.add(arr.get(i));
            int sumB = 0;
            while (pointer < arrayLen) {
                sumB += arr.get(pointer++);
            }
            if (sumA >= sumB) {
                break;
            }
        }

        return resultList;
    }
}
