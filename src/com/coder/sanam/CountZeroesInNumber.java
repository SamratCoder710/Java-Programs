package com.coder.sanam;

public class CountZeroesInNumber {

	static int counter = 0;
	public static void main(String[] args) {
		countZeroes(532111);
		System.out.println(counter);
	}

	static void countZeroes(int n) {
		if(n<1) {
			return;
		}
		int rem = n % 10;
		if (rem == 0) counter = counter + 1;
		countZeroes(n/10);
		 
	}
	
	
	
}
