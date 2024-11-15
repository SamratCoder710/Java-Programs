package com.coder.sanam;

public class Sqrt {
	public static int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int left = 1,right = x;
        while(left<=right){
            int mid = left + (right-left)/2;
            if((long) mid * mid > (long)x){
                right = mid -1;
            }else if((long) mid * mid < (long) x){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return Math.round(right);
    }
	
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
}
