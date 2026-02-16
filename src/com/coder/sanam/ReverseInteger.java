package com.coder.sanam;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int res = reverseInteger.reverse(-123);
        System.out.println(res);

    }

    public int reverse(int x) {
        long result = 0;

        while(x != 0){
            int digit = x % 10;
            result = result * 10 + digit;

            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
            x = x/10;
        }
        return (int) result;
    }
}
