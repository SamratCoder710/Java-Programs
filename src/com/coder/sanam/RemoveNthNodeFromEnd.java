package com.coder.sanam;

public class RemoveNthNodeFromEnd {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
		ListNode left = dummy;
		ListNode right = head;
		while(n>0 && right != null) {
			right = right.next;
			n--;
		}
		while(right != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return dummy.next;
    }

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
		ListNode resultNode = removeNthFromEnd(listNode,2);
		System.out.println(resultNode);
	}

}
