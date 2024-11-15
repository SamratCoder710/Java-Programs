package com.coder.sanam;

public class PalindromeLinkedList {
	
public boolean isPalindrome(ListNode head) {
		
		//find middle(slow pointer)
		ListNode fast = head , slow = head;
		while(fast!=null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// reverse second half 
		ListNode prev = null;
		ListNode curr = slow;
		
		while(curr!=null) {
			ListNode tmpNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmpNext;
		}
		
		ListNode left = head;
		ListNode right = prev;
		while (right != null) {
			if(right.val != left.val) return false;
			right = right.next;
			left = left.next;
		}
		return true;
	}
	
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	  public static void main(String[] args) {
		 int length =5;
		 int mid = length/2;
		System.out.println(mid);
	}
	 

}
