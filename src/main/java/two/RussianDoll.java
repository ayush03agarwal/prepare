package two;

import lombok.Data;

import java.util.*;

public class RussianDoll {
    public static void main(String[] args) {

        int m[][] = new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        RussianDoll r = new RussianDoll();
        System.out.println(r.maxEnvelopes(m));
    }

    public int maxEnvelopes(int[][] envelopes) {


        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });



        List<Comp> l = new ArrayList<>();
        int f = 0;

        for (int i = 0; i < envelopes.length; i++) {
            Comp c = new Comp();
            c.h = envelopes[i][1];
            c.w = envelopes[i][0];
            l.add(c);
        }
        Collections.sort(l);


        Comp c1 = l.get(0);
        for (int k = 1; k < l.size(); k++) {
            Comp c2 = l.get(k);
            if (c1.w < c2.w && c1.h < c2.h) {
                f++;
                c1 = c2;
            }

        }
        return f + 1;
    }

    class Comp implements Comparable<Comp> {
        int w;
        int h;

        @Override
        public int compareTo(Comp o) {
            int compare = Integer.compare(this.w, o.w);
            if (compare == 0) {
                return Integer.compare(this.h, o.h);
            }
            return Integer.compare(this.w, o.w);
        }
    }
}

