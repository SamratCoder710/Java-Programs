package com.coder.sanam;

public class RotateList {

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = rotateList.rotateRight(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }


    public ListNode rotateRightOptimal(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int L = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            dummy = dummy.next;
            L++;
        }
        k = k % L;
        if (k == 0) {
            return head;
        }


        ListNode tail = dummy;

        ListNode curr = head;
        for (int i = 1; i < L - k; i++) {
            curr = curr.next;
        }

        ListNode newTail = curr;
        ListNode newHead = curr.next;
        newTail.next = null;
        tail.next = head;


        return newHead;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = head;
        int n = 0;
        while (dummy != null) {
            dummy = dummy.next;
            n++;
        }
        k = k % n;
        if (k == 0) return head;
        head = reverse(head, 0, n - 1);
        head = reverse(head, 0, k - 1);
        head = reverse(head, k, n - 1);
        return head;
    }

    private ListNode reverse(ListNode head, int left, int right) {
        if (left == right) return head;

        // advance to node just before 'left'
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left; i++) prev = prev.next;

        ListNode curr = prev.next;
        ListNode tail = curr;
        ListNode reversedHead = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = reversedHead;
            reversedHead = curr;
            curr = next;
        }

        prev.next = reversedHead;
        tail.next = curr;

        return dummy.next;
    }


}
