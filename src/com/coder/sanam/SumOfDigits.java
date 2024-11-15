package com.coder.sanam;

public class SumOfDigits {

	public static void main(String[] args) {
		int res = pod(563);
		System.out.println(res);
	}

	static int sod(int n) {
		if(n == 0) {
			return 0;
		}
		return (n%10) + sod(n/10);
		 
	}
	
	static int pod(int n) {
		if(n == 0) {
			return 1;
		}
		return (n%10) * pod(n/10);
		 
	}
	
	
	
}
