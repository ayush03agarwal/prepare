package one;

import two.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(reverseList(l1));

    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;


        while (current != null) {

            next = current.next;
            current.next = prev;

            prev = current;
            current = next;

        }


        return prev;
    }
}
