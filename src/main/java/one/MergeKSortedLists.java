package one;

import two.ListNode;

import java.util.ArrayList;

public class MergeKSortedLists {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        l3.next.next = new ListNode(7);

        System.out.println(mergeKLists(new ListNode[]{l1, l2, l3}));

    }

    public static ListNode mergeKLists(ListNode[] lists) {


        if (lists.length == 1) {
            return lists[0];
        }


        while (lists.length > 1) {
            ArrayList<ListNode> merged = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < lists.length - 1; i = i + 2) {
                ListNode l1 = lists[i];
                ListNode l2 = null;
                if (i + 1 < lists.length) {
                    l2 = lists[i + 1];
                }
                merged.add(merge2Lists(l1, l2));
            }
            lists = merged.toArray(new ListNode[lists.length]);
        }

        return lists[0];


    }


    private static ListNode merge2Lists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;

        }

        if (l1 != null) {
            head.next = l1;
        }

        if (l2 != null) {
            head.next = l2;
        }

        return dummy.next;

    }


}
