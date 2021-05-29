package two;

public class ReverseLL {

    public static void main(String[] args) {
        Node n = new Node();
        n.data = 1;
        n.next = new Node();
        n.next.data = 2;
        n.next.next = new Node();
        n.next.next.data = 3;
        n.next.next.next = new Node();
        n.next.next.next.data = 4;
        n.next.next.next.next = new Node();
        n.next.next.next.next.data = 5;
        System.out.println(reverseList(n));

    }

    static Node reverseList(Node head) {

        Node c = head;
        Node n = c.next;
        Node p = null;

        while (n != null) {
            c.next = p;
            p = c;
            c = n;
            n = n.next;
        }
        c.next = p;
        return c;

    }
}
