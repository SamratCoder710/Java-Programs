package com.coder.sanam;

public class Palindrome {

	static boolean isPalindrome(int[] arr,int s, int e) {
		if (s > e) {
			return true;
		}
		if(arr[s] != arr[e]) {
			return false;
		}
		
		return isPalindrome(arr, s+1, e-1);
	}
	
	static boolean isPalindrome(String k,int s, int e) {
		if (s > e) {
			return true;
		}
		if(k.charAt(s) != k.charAt(e)) {
			return false;
		}
		
		return isPalindrome(k, s+1, e-1);
	}

	public static void main(String[] args) {
		int num = 124213;
		String s = String.valueOf(num);
		int[] arr = { 1, 2, 4, 2,1 ,7};
		System.out.println(isPalindrome(s,0,s.length() -1));
	}

}
