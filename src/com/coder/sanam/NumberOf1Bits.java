package com.coder.sanam;

public class NumberOf1Bits {
	
	public static int hammingWeight(int n) {
        int lsb = 0;
        int res =  0;
        for(int i=0;i<32;i++){
            lsb = n & 1;
            if(lsb == 1)  res+= 1;
            n = n >> 1;
        }
        return res;
	}
	
	public static void main(String[] args) {
		int result = hammingWeight(12);
		System.out.println(result);
	}

}
