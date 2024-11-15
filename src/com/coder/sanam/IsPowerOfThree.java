package com.coder.sanam;

public class IsPowerOfThree {
	public static boolean isPowerOfThree(int n) {
		double k = (double)n;
        while(k>=3){
        	System.out.println(k);
            k=k/(double)3;
            
            if(k==1){
                return true;
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
		boolean powerOfThree = isPowerOfThree(27);
		System.out.println(powerOfThree);
	}
}
