package one;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {
    public static void main(String[] args) {

        int position[] = {10, 8, 0, 5, 3};
        int speed[] = {2, 4, 1, 1, 3};

        System.out.println(carFleet(12, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {

        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            tm.put(position[i], speed[i]);
        }

        int count = 1;

        int pos1 = 0;
        int sp1 = 0;

        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {

            if (sp1 == 0) {
                pos1 = e.getKey();
                sp1 = e.getValue();
            } else {
                int pos2 = e.getKey();
                int sp2 = e.getValue();
                float t1 = (float) (target - pos1) / sp1;
                float t2 = (float) (target - pos2) / sp2;
                if (t2 > t1) {
                    count++;
                    pos1 = pos2;
                    sp1 = sp2;
                }
            }

        }
        return count;
    }
}
