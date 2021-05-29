package two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    public static void main(String[] args) {

        System.out.println(tour(new int[]{78, 87, 94, 16, 87, 36, 50, 93, 63, 22, 91, 28, 64, 60, 41, 27, 73, 27, 12, 37, 68, 69, 83, 30, 63, 31, 68, 24, 30, 36, 23, 3, 70, 59,
                },
                new int[]{94, 68, 12, 57, 30, 43, 22, 74, 85, 20, 99, 38, 16, 25, 14, 71, 92, 27, 57, 81, 63, 74, 97, 71, 6, 82, 85, 26, 37, 28, 47, 6, 14, 30
                }));
    }

    static int tour(int petrol[], int distance[]) {

        Queue<Integer> q = new LinkedList<>();
        System.out.println(Arrays.toString(petrol));
        System.out.println(Arrays.toString(distance));
        int s = 0;
        int c = -1;
        int t = 0;
        for (int i = 0; i < petrol.length; i++) {
            int f = petrol[i] - distance[i];
            s += f;
            t += f;
            if (f >= 0 || t >= 0) {
                q.add(i);
            } else {
                while (!q.isEmpty()) {
                    int a = q.poll();
                    t = t - (petrol[a] - distance[a]);
                    if (t + f >= 0) {
                        break;
                    }
                }
                t = 0;
            }
        }

        if (s < 0 || q.isEmpty()) {
            c = -1;
        } else {
            c = q.poll();
        }
        return c;
    }
}
