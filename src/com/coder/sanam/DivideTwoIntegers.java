package com.coder.sanam;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor== -1) return Integer.MAX_VALUE;
        boolean negativeSign = (dividend<0)^(divisor<0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while(dividend - divisor >= 0) {
        	int curDivisor = divisor;
        	int curQuotient = 1;
        	while((dividend - (curDivisor << 1)) >=0) {
        		curDivisor = curDivisor << 1;
        		curQuotient = curQuotient << 1;
        	}
        	quotient += curQuotient;
        	dividend -= curDivisor;
        }
        return negativeSign?-quotient: quotient;
    }
	
	public static void main(String[] args) {
		int divide = divide(10,3);
		System.out.println(divide);
	}
}
