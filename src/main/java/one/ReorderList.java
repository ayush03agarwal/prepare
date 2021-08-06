package one;

import two.ListNode;

public class ReorderList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        reorderList(l1);
        System.out.println("dafa");
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }


        ListNode s = head;
        ListNode f = head.next;


        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode second = reverse(s.next);
        s.next = null;

        ListNode first = head;
        while (second != null) {
            ListNode temp = first.next;
            ListNode tempNext = second.next;
            first.next = second;
            second.next = temp;
            first = temp;
            second = tempNext;
        }


    }


    private static ListNode reverse(ListNode l) {

        if (l == null || l.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode current = l;
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
