package two;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        r.add(1);
        rooms.add(r);


        r = new ArrayList<>();
        r.add(2);
        rooms.add(r);


        r = new ArrayList<>();
        r.add(3);
        rooms.add(r);

        r = new ArrayList<>();
        rooms.add(r);


        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean arr[] = new boolean[rooms.size()];

        boolean r = true;
        int s = 0;
        arr[0] = true;
        visit(0, rooms, arr);

        boolean b = true;
        for (int i = 0; i < arr.length; i++) {
            b = b && arr[i];
        }
        return b;
    }

    private static void visit(int s, List<List<Integer>> rooms, boolean arr[]) {
        List<Integer> t = rooms.get(s);
        for (int i : t) {
            if (!arr[i]) {
                arr[i] = true;
                visit(i, rooms, arr);
            }
        }

    }
}
