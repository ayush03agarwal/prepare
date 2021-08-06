package one;

import two.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
//        l1.next.next.next = new ListNode(5);
//        l1.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next = new ListNode(7);

        System.out.println(removeNthFromEnd(l1, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode s = dummy;
        ListNode f = dummy;

        while (n >= 0) {
            f = f.next;
            n--;
        }

        while (f != null) {
            s = s.next;
            f = f.next;
        }

        s.next = s.next.next;


        return dummy.next;


    }
}
