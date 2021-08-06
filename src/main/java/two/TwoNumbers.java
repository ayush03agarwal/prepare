package two;

public class TwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 9;
        l1.next = new ListNode();
        l1.next.val = 8;
        l1.next.next = new ListNode();
        l1.next.next.val = 7;

        ListNode l2 = new ListNode();
        l2.val = 0;
        l2.next = new ListNode();
        l2.next.val = 6;
        l2.next.next = new ListNode();
        l2.next.next.val = 1;

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head3 = l3;
        int carry = 0;

        while (head1 != null && head2 != null) {
            int i = head1.val;
            int j = head2.val;
            int val = i + j + carry;
            carry = 0;
            int k = 0;
            if (val < 9) {
                k = val;
            } else {
                k = val % 10;
                carry = val / 10;
            }
            head3.val = k;
            head1 = head1.next;
            head2 = head2.next;

            if (head1 != null && head2 != null) {
                head3.next = new ListNode();
                head3 = head3.next;
            }

        }

        while (head1 != null) {
            head3.next = new ListNode();
            head3 = head3.next;
            int i = head1.val;
            int val = i + carry;
            carry = 0;
            int k = 0;
            if (val <= 9) {
                k = val;
            } else {
                k = val % 10;
                carry = val / 10;
            }
            head3.val = k;
            head1 = head1.next;
        }

        while (head2 != null) {
            head3.next = new ListNode();
            head3 = head3.next;
            int i = head2.val;
            int val = i + carry;
            carry = 0;
            int k = 0;
            if (val < 9) {
                k = val;
            } else {
                k = val % 10;
                carry = val / 10;
            }
            head3.val = k;
            head2 = head2.next;
        }

        if (carry != 0) {
            head3.next = new ListNode();
            head3 = head3.next;
            head3.val = carry;
        }

        return l3;

    }
}

