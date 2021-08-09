package one;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements e = new TopKFrequentElements();

        int[] n = {4, 4, 4, 4, 4, 1, 1, 1, 2, 2, 3};
        int[] i = e.topKFrequent(n, 2);
        System.out.println(i);
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Node n = new Node();
            n.value = e.getKey();
            n.freq = e.getValue();
            pq.add(n);
        }

        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(pq.poll().value);
            k--;
        }

        int[] r = new int[res.size()];
        for (int x = 0; x < res.size(); x++) {
            r[x] = res.get(x);
        }
        return r;

    }

    class Node implements Comparable<Node> {
        int value;
        int freq;

        Node() {
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.freq, freq);
        }
    }
}
