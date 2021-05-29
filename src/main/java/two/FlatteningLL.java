package two;

public class FlatteningLL {
    public static void main(String[] args) {
        FNode head = new FNode(5);
        head.bottom = new FNode(7);
        head.bottom.bottom = new FNode(8);
        head.bottom.bottom.bottom = new FNode(30);

        head.next = new FNode(10);
        head.next.bottom = new FNode(20);

        head.next.next = new FNode(19);
        head.next.next.bottom = new FNode(22);
        head.next.next.bottom.bottom = new FNode(50);

        head.next.next.next = new FNode(28);
        head.next.next.next.bottom = new FNode(35);
        head.next.next.next.bottom.bottom = new FNode(40);
        head.next.next.next.bottom.bottom.bottom = new FNode(45);

        System.out.println(flatten(head));
        System.out.println("dsd");
    }

    private static FNode flatten(FNode root) {

        if (root.bottom == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);
        root = merge(root, root.next);

        return root;

    }

    private static FNode merge(FNode a, FNode b) {

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        FNode result = null;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null;
        return result;
    }

}

class FNode {
    int data;
    FNode next;
    FNode bottom;

    FNode(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

