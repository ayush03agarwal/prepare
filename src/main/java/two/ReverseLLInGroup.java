package two;

public class ReverseLLInGroup {

    public static void main(String[] args) {
        Node n = new Node();
        n.data = 1;
        n.next = new Node();
        n.next.data = 2;
        n.next.next = new Node();
        n.next.next.data = 2;
        n.next.next.next = new Node();
        n.next.next.next.data = 4;
        n.next.next.next.next = new Node();
        n.next.next.next.next.data = 5;
        n.next.next.next.next.next = new Node();
        n.next.next.next.next.next.data = 6;
        n.next.next.next.next.next.next = new Node();
        n.next.next.next.next.next.next.data = 7;
        n.next.next.next.next.next.next.next = new Node();
        n.next.next.next.next.next.next.next.data = 8;

        System.out.println(reverseList(n, 3));

    }

    public static Node reverseList(Node node, int k) {
        //Your code here

        Node c = node;
        Node n = c.next;
        Node p = null;
        Node h = null;

        while (n != null) {
            int count = k;
            while (count > 0) {
                c.next = p;
                p = c;
                c = n;
                n = n.next;
                count--;
            }
        }
        c.next = p;
        return c;

    }



}
