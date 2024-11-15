package com.coder.sanam;

import java.util.LinkedList;

public class StackLinkedList {
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addLast(3);
		list.addLast(2);
		list.addLast(4);
		
		System.out.println(list.pollFirst());
		list.addLast(5);
		list.addLast(6);
		System.out.println(list);
		System.out.println(list.pollFirst());
	}

}
