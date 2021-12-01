package one;


public class CopyListWithRandomPointer {
    public static void main(String[] args) {

        Node h1 = new Node(7);
        Node h2 = new Node(13);
        Node h3 = new Node(11);
        Node h4 = new Node(10);
        Node h5 = new Node(1);

        h1.next = h2;
        h1.random = null;

        h2.next = h3;
        h2.random = h1;

        h3.next = h4;
        h3.random = h5;

        h4.next = h5;
        h4.random = h3;

        h5.next = null;
        h5.random = h1;

        System.out.println(copyRandomList(h1));


    }

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }


        Node copyHead = createCopy(head);
        Node headPointer = head;
        Node copyHeadPointer = copyHead;

        while (headPointer != null) {
            Node temp = headPointer.next;
            headPointer.next = copyHeadPointer;
            copyHeadPointer = copyHeadPointer.next;
            headPointer = temp;
        }

        headPointer = head;
        copyHeadPointer = copyHead;

        while (copyHeadPointer != null) {
            Node temp = copyHeadPointer.random;
            if (temp.random != null) {
                copyHeadPointer.random = temp.random.next;
            } else {
                copyHeadPointer.random = null;
            }
            copyHeadPointer = copyHeadPointer.next;

        }
        return copyHead;

    }

    static Node createCopy(Node head) {

        Node copyHead = head;
        Node newList = new Node(-1);
        Node newHeadPointer = newList;
        Node prev = null;

        while (copyHead != null) {
            Node newNode = new Node(copyHead.val);
            newNode.random = copyHead;
            if (prev != null) {
                prev.next = newNode;
            }
            prev = newNode;
            newList.next = newNode;
            newList = newList.next;
            copyHead = copyHead.next;
        }
        return newHeadPointer.next;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
