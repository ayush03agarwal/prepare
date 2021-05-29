package two;

public class FindingMiddleElementLL {


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
        System.out.println(getMiddle(n));
    }

    static int getMiddle(Node head) {
        Node s = head;
        Node d = head;

        int c = 0;
        while (d != null) {
            if (d.next == null) {
                break;
            }
            s = s.next;
            d = d.next.next;
            c++;
        }

        return s.data;

    }
}

