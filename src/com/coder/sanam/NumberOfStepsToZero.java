package com.coder.sanam;

public class NumberOfStepsToZero {

	static int step = 0;

	public static void main(String[] args) {
		System.out.println(helper(12,0));
	}
	static void numberOfSteps(int n) {
		if(n == 0) {
			return;
		}
		step = step +1;
		if(n%2 == 0) {
			numberOfSteps(n/2);	
		}else {
			numberOfSteps(n-1);
		}
		 
	}
	
	// Alternative passing step into args


	static int helper(int n,int step) {
		if(n == 0) {
			return step;
		}
		if(n%2 == 0) {
			return helper(n/2,step +1);	
		}
			return helper(n-1,step +1);
		 
	}
	
	
	
	
}
