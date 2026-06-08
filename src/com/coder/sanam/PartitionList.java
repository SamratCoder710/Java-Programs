package com.coder.sanam;

public class PartitionList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = partitionList.partition(head, 3);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                before.next = new ListNode(curr.val);
                before = before.next;
            } else {
                after.next = new ListNode(curr.val);
                after = after.next;
            }
            curr = curr.next;
        }

        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
