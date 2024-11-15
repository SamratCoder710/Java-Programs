package com.coder.sanam;

public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
        int noOfZeroes = 0;
        while(n>0){
            noOfZeroes+= n/5;
            n = n/5;
        }
        return noOfZeroes;
    }
	
	public static void main(String[] args) {
		int trailingZeroes = trailingZeroes(1000);
		System.out.println(trailingZeroes);
	}
}
