package two;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {

        Node[] arr = new Node[3];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        Node n = mergeKList(arr, arr.length);
        System.out.println(n);

    }

    static Node mergeKList(Node[] arr, int K) {
        Node f = null;
        Node head = f;
        Node a1 = arr[0];
        Node a2 = null;

        for (int i = 1; i < arr.length; i++) {
            a2 = arr[i];
            Node h1 = a1;
            Node h2 = a2;
            while (h1 != null && h2 != null) {
                if (h1.data < h2.data) {
                    f = new Node(h1.data);
                    System.out.println(f.data);
                    h1 = h1.next;
                } else {
                    f = new Node(h2.data);
                    System.out.println(f.data);

                    h2 = h2.next;
                }
                f = f.next;
            }
            while (h1 != null) {
                f = new Node(h1.data);
                System.out.println(f.data);

                f = f.next;
                h1 = h1.next;
            }
            while (h2 != null) {
                f = new Node(h2.data);
                System.out.println(f.data);

                f = f.next;
                h2 = h2.next;
            }
        }
        return f;
    }
}
