package com.coder.sanam;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	    public static boolean isHappy(int n) {
	        Set<Integer> res = new HashSet<>();
	        while(!res.contains(n)){
	            res.add(n);
	            n = sumOfSquares(n);
	            if(n==1) return true;
	        }
	        return false;
	    }

	    private static int sumOfSquares(int n){
	        int sum = 0;
	        while(n>0){
	            int curr_last = n%10;
	            sum += curr_last * curr_last;
	            n = n/10;
	        }
	        return sum;
	    }
	    
	    public static void main(String[] args) {
			boolean happy = isHappy(2);
			System.out.println(happy);
		}

}
