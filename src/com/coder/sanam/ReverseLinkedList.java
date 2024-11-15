package com.coder.sanam;

public class ReverseLinkedList {
	
	// 1 -> 2 -> 3 -> 4 -> 5

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(head  != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;

	}
	

	public class ListNode {
		int head;
		ListNode next;

		ListNode() {
		}

		ListNode(int head) {
			this.head = head;
		}

		ListNode(int head, ListNode next) {
			this.head = head;
			this.next = next;
		}
	}
}
