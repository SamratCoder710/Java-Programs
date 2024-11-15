package com.coder.sanam;

import java.util.PriorityQueue;

public class KthLargestElementOfArray {
	
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pque = new PriorityQueue<Integer>();
		for(int x:nums) {
			pque.offer(x);
		}
		int index = nums.length -k;
		while(index>0) {
			pque.poll();
			index--;
		}
		return pque.peek();
    }
	
	public static void main(String[] args) {
		int findKthLargest = findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4);
		System.out.println(findKthLargest);
	}

}
