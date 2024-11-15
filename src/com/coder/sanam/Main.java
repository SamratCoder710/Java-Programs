package com.coder.sanam;

public class Main {

	public static void main(String[] args) {
		printNumBoth(5);
	}

	static void printNum(int n) {
		if(n == 0) {
			return ;
		}
		System.out.println(n);
		 printNum(n-1);
		 
	}
	
	static void printNumRev(int n) {
		if(n == 0) {
			return ;
		}
		printNumRev(n-1);
		System.out.println(n);
	}
	
	static void printNumBoth(int n) {
		if(n == 0) {
			return ;
		}
		System.out.println(n);
		printNumBoth(n-1);
		System.out.println(n);
	}
	
	
}
