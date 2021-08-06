package one;

import two.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = l1;

        System.out.println(hasCycle(l1));
    }

    public static boolean hasCycle(ListNode head) {


        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        ListNode s = head.next;
        ListNode f = head.next.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }
        return false;


    }
}
