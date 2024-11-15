package com.coder.sanam;

public class ReverseOfDigits {

	static int sum = 0;
	static void reverseOfDigits(int n) {
		int rem = n % 10;
		if(rem == 0) {
			return ;
		}
		sum = sum * 10 + rem;
		reverseOfDigits(n/10);
		
		 
	}
	
	// Alternative Solution
	static int rod(int n, int nargs) {
		if(nargs-1 == 0) {
			return n;
		}
		return (n % 10) * (int)Math.pow(10, nargs - 1)  + rod(n/10,nargs -1 );
	}
	
	public static void main(String[] args) {
		int n = 12321;
		System.out.println("Number :"+n);
		int result = rod(n,counterLog(n));
		System.out.println("Reverse :"+result);
		System.out.println("Is a Palindrome?"+palindrome(n));
		
	}
	

	private static int counter(int i) {
		int counter = 0;
		while(i >=1) {
			counter = counter + 1;
			i = i/10;
		}
		System.out.println("Counter"+counter);
		return counter;
	}
	
	//Alternative counter 
	private static int counterLog(int k) {
		return (int)(Math.log10(k))+1;
	}

	
	static boolean palindrome(int k) {
		return k == rod(k,counterLog(k));
	}
	
	
	
}
