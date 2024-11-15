package com.coder.sanam;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
        String replaceAll = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = replaceAll.length();
        for(int i=0;i<len/2;i++) {
        	if(replaceAll.charAt(i)!= replaceAll.charAt(len-i-1)) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(palindrome);
	}
}
