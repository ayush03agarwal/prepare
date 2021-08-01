package one;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        GNode onenode = new GNode();
        GNode twonode = new GNode();
        GNode threenode = new GNode();
        GNode fournode = new GNode();
        onenode.val = 1;
        twonode.val = 2;
        threenode.val = 3;
        fournode.val = 4;

        List<GNode> n = new ArrayList<>();
        n.add(twonode);
        n.add(fournode);
        onenode.neighbors = n;

        n = new ArrayList<>();
        n.add(onenode);
        n.add(threenode);
        twonode.neighbors = n;

        n = new ArrayList<>();
        n.add(twonode);
        n.add(fournode);
        threenode.neighbors = n;

        n = new ArrayList<>();
        n.add(onenode);
        n.add(threenode);
        fournode.neighbors = n;
        GNode gNode = cloneGraph(onenode);
        System.out.println(gNode);
    }

    public static GNode cloneGraph(GNode node) {

        Map<Integer, GNode> m = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        Queue<GNode> q = new LinkedList<>();
        q.add(node);
        GNode newNode = null;
        GNode head = null;


        while (!q.isEmpty()) {
            if (q.peek() == null) {
                q.poll();
                continue;
            }
            if (s.contains(q.peek().val)) {
                q.poll();
                continue;
            }
            GNode poll = q.poll();
            newNode = m.getOrDefault(poll.val, new GNode());
            newNode.val = poll.val;
            List<GNode> neighbors = newNode.neighbors;
            for (GNode g : poll.neighbors) {
                GNode nei = m.getOrDefault(g.val, new GNode());
                nei.val = g.val;
                neighbors.add(nei);
                q.add(g);
                m.put(g.val, nei);
            }
            m.put(newNode.val, newNode);
            s.add(newNode.val);
            if (head == null) {
                head = newNode;
            }
        }
        return head;
    }

}

class GNode {
    public int val;
    public List<GNode> neighbors;

    public GNode() {
        val = 0;
        neighbors = new ArrayList<GNode>();
    }

    public GNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GNode>();
    }

    public GNode(int _val, ArrayList<GNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}